import { Component, OnInit } from '@angular/core';
import { NavLink } from '../nav-link/nav-link.component';
import { Router } from '@angular/router';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
    navLinks: NavLink[] = [
        { displayText: 'Browse', navigatePath: '/browse', selected: false },
        { displayText: 'News', navigatePath: '/news', selected: false },
    ];

    constructor(private _router: Router) {}

    ngOnInit(): void {}

    handleNavLinkClick(navLink: NavLink) {
        this.navLinks.forEach((navLink) => (navLink.selected = false));
        navLink.selected = true;
    }

    async navigateToIndex() {
        this.navLinks.forEach((navLink) => (navLink.selected = false));
        await this._router.navigateByUrl('');
    }
}
