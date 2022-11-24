import SwiftUI

@main
struct iOSApp: App {
    
    private let module: CoreModule = CoreModule.shared
    
	var body: some Scene {
		WindowGroup {
            HomeView(
                viewModel: HomeViewModel(
                    getItemList: module.provideGetItemList()
                )
            )
		}
	}
}
