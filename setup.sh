#!/usr/bin/env bash
set -euo pipefail

# ============================================================
# Template Setup Script
# ============================================================
# Replaces "Skeleton" / "com.rmakiyama.skeleton" references
# throughout the project with your app's values.
#
# Usage:
#   ./setup.sh \
#     --app-name "MyApp" \
#     --package "com.example.myapp" \
#     [--project-name "my-app"]
#
# --project-name defaults to lowercase app-name with hyphens.
# ============================================================

OLD_PACKAGE="com.rmakiyama.skeleton"
OLD_PACKAGE_PATH="com/rmakiyama/skeleton"
OLD_APP_NAME="Skeleton"
OLD_PROJECT_NAME="app-skeleton"

APP_NAME=""
PACKAGE=""
PROJECT_NAME=""

usage() {
    echo "Usage: $0 --app-name <name> --package <package> [--project-name <name>]"
    echo ""
    echo "  --app-name      Display name of the app (e.g. MyApp)"
    echo "  --package       Package name (e.g. com.example.myapp)"
    echo "  --project-name  Gradle root project name (default: derived from app-name)"
    exit 1
}

# --- Parse arguments ---
while [[ $# -gt 0 ]]; do
    case "$1" in
        --app-name)   APP_NAME="$2"; shift 2 ;;
        --package)    PACKAGE="$2"; shift 2 ;;
        --project-name) PROJECT_NAME="$2"; shift 2 ;;
        -h|--help)    usage ;;
        *)            echo "Unknown option: $1"; usage ;;
    esac
done

if [[ -z "$APP_NAME" || -z "$PACKAGE" ]]; then
    echo "Error: --app-name and --package are required."
    usage
fi

# Derive project name if not given: lowercase, replace spaces with hyphens
if [[ -z "$PROJECT_NAME" ]]; then
    PROJECT_NAME=$(echo "$APP_NAME" | tr '[:upper:]' '[:lower:]' | tr ' ' '-')
fi

PACKAGE_PATH="${PACKAGE//\.//}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

echo "=== Template Setup ==="
echo "  App name:      $APP_NAME"
echo "  Package:       $PACKAGE"
echo "  Project name:  $PROJECT_NAME"
echo "  Package path:  $PACKAGE_PATH"
echo ""

# --- Step 1: Replace file contents ---
echo "[1/4] Replacing file contents..."

# Collect target files (exclude .git, build dirs, this script, and binary files)
target_files() {
    find . \
        -not -path './.git/*' \
        -not -path '*/build/*' \
        -not -path './.gradle/*' \
        -not -path './.idea/*' \
        -not -name 'setup.sh' \
        -type f \
        \( -name '*.kt' -o -name '*.kts' -o -name '*.xml' -o -name '*.sq' -o -name '*.md' -o -name '*.swift' -o -name '*.plist' -o -name '*.pbxproj' -o -name '*.xcscheme' \)
}

# Order matters: longest match first to avoid partial replacements

# 1a. Package name (dot notation): com.rmakiyama.skeleton -> new package
target_files | xargs sed -i '' "s|${OLD_PACKAGE}|${PACKAGE}|g"

# 1b. Package path (slash notation): com/rmakiyama/skeleton -> new path
target_files | xargs sed -i '' "s|${OLD_PACKAGE_PATH}|${PACKAGE_PATH}|g"

# 1c. Convention plugin IDs: skeleton.xxx -> newprefix.xxx
#     The plugin prefix is the last segment of the package
PLUGIN_PREFIX="${PACKAGE##*.}"
target_files | xargs sed -i '' "s|\"skeleton\.|\"${PLUGIN_PREFIX}.|g"

# 1d. App name / class prefix: Skeleton -> AppName
target_files | xargs sed -i '' "s|${OLD_APP_NAME}|${APP_NAME}|g"

# 1e. Project name: app-skeleton -> new project name
target_files | xargs sed -i '' "s|${OLD_PROJECT_NAME}|${PROJECT_NAME}|g"

echo "    Done."

# --- Step 2: Rename files containing "Skeleton" ---
echo "[2/4] Renaming files..."

find . \
    -not -path './.git/*' \
    -not -path '*/build/*' \
    -not -path './.gradle/*' \
    -not -name 'setup.sh' \
    -type f -name "*${OLD_APP_NAME}*" | while read -r filepath; do
    dir=$(dirname "$filepath")
    oldname=$(basename "$filepath")
    newname="${oldname//${OLD_APP_NAME}/${APP_NAME}}"
    mv "$filepath" "$dir/$newname"
    echo "    $filepath -> $dir/$newname"
done

echo "    Done."

# --- Step 3: Move source directories to new package path ---
echo "[3/4] Restructuring package directories..."

find . \
    -not -path './.git/*' \
    -not -path '*/build/*' \
    -not -path './.gradle/*' \
    -type d -path "*/${OLD_PACKAGE_PATH}" | sort -r | while read -r old_dir; do
    # Compute new directory path
    new_dir="${old_dir//${OLD_PACKAGE_PATH}/${PACKAGE_PATH}}"

    if [[ "$old_dir" == "$new_dir" ]]; then
        continue
    fi

    # Create new parent directory
    mkdir -p "$new_dir"

    # Move all contents
    if [[ -n "$(ls -A "$old_dir" 2>/dev/null)" ]]; then
        mv "$old_dir"/* "$new_dir"/ 2>/dev/null || true
        # Also move hidden files if any
        mv "$old_dir"/.* "$new_dir"/ 2>/dev/null || true
    fi

    echo "    $old_dir -> $new_dir"
done

echo "    Done."

# --- Step 4: Clean up empty old directories ---
echo "[4/4] Cleaning up empty directories..."

# Remove empty directories left behind from the move
# Run multiple passes to handle nested empties
for _ in 1 2 3 4 5; do
    find . \
        -not -path './.git/*' \
        -not -path '*/build/*' \
        -not -path './.gradle/*' \
        -type d -empty -delete 2>/dev/null || true
done

echo "    Done."

echo ""
echo "=== Setup complete! ==="
echo ""
echo "Next steps:"
echo "  1. Review the changes: git diff"
echo "  2. Build to verify:    ./gradlew assembleDebug"
echo "  3. Remove this script: rm setup.sh"
echo "  4. Commit the result"
