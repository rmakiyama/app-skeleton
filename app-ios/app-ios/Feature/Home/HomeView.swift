import SwiftUI
import core

struct HomeView: View {
    
    @ObservedObject var viewModel: HomeViewModel
    
    init(viewModel: HomeViewModel) {
        self.viewModel = viewModel
        viewModel.load()
    }
    
    var body: some View {
        NavigationView{
           List(viewModel.state.items, id: \.hashValue) { item in
               ItemView(item: item)
           }
           .navigationTitle("Home")
        }
    }
}

struct ItemView: View {
    
    let item: Item
    
    init(item: Item) {
        self.item = item
    }
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(item.title).font(.title2)
            if let description = item.description_ {
                Text(description)
            }
        }
    }
}
