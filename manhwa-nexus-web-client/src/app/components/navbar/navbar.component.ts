import {Component, OnInit} from '@angular/core';
import {NavLink} from "../nav-link/nav-link.component";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  navLinks: NavLink[] = [
    {displayText: "Browse", navigatePath: "/browse", selected: false},
    {displayText: "News", navigatePath: "/news", selected: false},
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

  handleNavLinkClick(navLink: NavLink) {
    navLink.selected = true;
    this.navLinks.forEach(navLink => navLink.selected = false);
    navLink.selected = true;
  }
}

