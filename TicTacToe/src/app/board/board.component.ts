import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {

  square: any[];
  nextPerson: boolean;
  win: string;
  playerX: any[];
  playerO: any[];
  isdraw: boolean;
  squareIndex: number;
  chanceofWinning: boolean;
  humanWinningIndex: number;
  virtualWinningIndex: number;
  combinationOfWinnerArray: any[];
  
  constructor() { }

  ngOnInit() {
    this.newGame();
  }

  newGame() {
    this.square = Array(9).fill(null);
    this.nextPerson = true;
    this.win = null;
    this.playerX = [];
    this.playerO = [];
    this.isdraw = false;
    this.squareIndex = 0;
    this.combinationOfWinnerArray = [
      [0,1,2],
      [3,4,5],
      [6,7,8],
      [0,3,6],
      [1,4,7],
      [2,5,8],
      [0,4,8],
      [2,4,6]
    ];
  }

  get player() {
    return this.nextPerson ? 'X' : 'O';
  }

  move(id : number) {
    if(!this.square[id]){
      this.square.splice(id, 1, this.player); 
      this.nextPerson ? this.playerX.push(id) : this.playerO.push(id);
      this.nextPerson = !this.nextPerson;
      if(!this.nextPerson){
        setTimeout(d => {this.computerMove()},1000);
      }
    }
    this.win = this.decideTheWinner();
    if((this.win == null) && (this.playerX.length + this.playerO.length == 9)){
      return this.isdraw = true;
    }
  }

  computerMove(){
    if(this.playerX.length === 1){
      this.squareIndex = (Math.floor(Math.random() * (8 - 0) + 1)) - this.playerX[0];
      while(this.square[this.squareIndex] !== null){
        this.squareIndex = (Math.floor(Math.random() * (8 - 0) + 1)) - this.playerX[0];
        console.log(this.squareIndex);
      }
      this.move(this.squareIndex);
    }else if(this.checkHumanIsWinning() ){
      console.log(" Human winning Index " + this.humanWinningIndex);
      this.move(this.humanWinningIndex);
    }else{
      this.virtualWinningIndex = this.makeComputerWin();
        if(this.square[this.virtualWinningIndex] === null){
          console.log(" Computer's next move " + this.virtualWinningIndex);
          this.move(this.virtualWinningIndex);
        }  
    }
  }
 
  checkHumanIsWinning(): boolean{
    this.chanceofWinning = false;
    this.humanWinningIndex = 0;
      for(let i=0; i < this.combinationOfWinnerArray.length; i++ ){
        const [a,b,c] = this.combinationOfWinnerArray[i];
          if(this.square[a] === this.square[b] && this.square[a] !== this.player && this.square[a] !== null && this.square[c] === null){
            this.humanWinningIndex = c;
            this.chanceofWinning = true;
          }else if(this.square[b] === this.square[c] && this.square[b] !== this.player && this.square[b] !== null && this.square[a] === null){
            this.humanWinningIndex=a;
            this.chanceofWinning = true;
          }else if(this.square[a] === this.square[c] && this.square[a] !== this.player && this.square[a] !== null && this.square[b] === null){
            this.humanWinningIndex=b;
            this.chanceofWinning = true;
          }
      }
      return this.chanceofWinning;
  }

  makeComputerWin() : number{
    for(let i=0; i < this.combinationOfWinnerArray.length; i++){
      const[a,b,c] = this.combinationOfWinnerArray[i];
        if(this.square[a] === null){
          return a;
        }else if(this.square[b] === null){
          return b;
        }else if(this.square[c] === null){
          return c;
        }
    }
  }


  decideTheWinner() {
    for(let i = 0; i < this.combinationOfWinnerArray.length; i++) {
      const [a,b,c] = this.combinationOfWinnerArray[i];
      if(this.square[a] &&
        this.square[a] === this.square[b] &&
        this.square[a] === this.square[c]){
          return this.square[a];
        }     
    }
    return null;
  }

}
