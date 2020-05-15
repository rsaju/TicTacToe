import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-square',
  templateUrl: './square.component.html',
  styleUrls: ['./square.component.css']
})
export class SquareComponent implements OnInit {

  constructor() { }

  @Input() symbol: 'X' | 'O';

  ngOnInit() {
  
  }

}
