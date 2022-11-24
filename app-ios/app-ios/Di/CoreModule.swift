import Foundation
import core

final class CoreModule {
    
    static let shared = CoreModule()
    
    private let useCaseModule: UseCaseModule
    private init(
        useCaseModule: UseCaseModule = UseCaseModule.companion.get()
    ) {
        self.useCaseModule = useCaseModule
    }
    
    func provideGetItemList() -> GetItemList {
        useCaseModule.provideGetItemList()
    }
}
