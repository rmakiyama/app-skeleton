import Foundation
import Combine
import core

class HomeViewModel: ObservableObject {
    
    @Published var state = State()
    
    private let getItemList: GetItemList
    init(
        getItemList: GetItemList = CoreModule.shared.provideGetItemList()
    ) {
        self.getItemList = getItemList
    }
    
    func load() {
        getItemList.invoke { items, _ in
            if let items = items {
                self.state.items = items
            }
        }
    }
    
    struct State {
        var items: [Item] = []
    }
}
