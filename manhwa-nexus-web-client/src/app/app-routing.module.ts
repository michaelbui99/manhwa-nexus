import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./pages/index/index.component";
import {BrowseComponent} from "./pages/browse/browse.component";
import {NewsComponent} from "./pages/news/news.component";

const routes: Routes = [
  {path: "", component: IndexComponent},
  {path: "browse", component: BrowseComponent},
  {path: "news", component: NewsComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
