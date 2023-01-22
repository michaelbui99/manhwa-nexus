import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { IndexComponent } from './pages/index/index.component';
import { MatButtonModule } from '@angular/material/button';
import { NavLinkComponent } from './components/nav-link/nav-link.component';
import { BrowseComponent } from './pages/browse/browse.component';
import { NewsComponent } from './pages/news/news.component';
import { FormsModule } from '@angular/forms';
import { NgSelectModule } from '@ng-select/ng-select';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { ManhwaCardComponent } from './components/manhwa-card/manhwa-card.component';
import { ManhwaGridComponent } from './components/manhwa-grid/manhwa-grid.component';

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        IndexComponent,
        NavLinkComponent,
        BrowseComponent,
        NewsComponent,
        ManhwaCardComponent,
        ManhwaGridComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatButtonModule,
        HttpClientModule,
        FormsModule,
        NgSelectModule,
        MatSnackBarModule,
    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
