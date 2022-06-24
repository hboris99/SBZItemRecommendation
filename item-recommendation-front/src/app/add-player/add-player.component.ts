import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { userInfo } from 'os';
import { PlayerClass, User, Item} from '../model/Player';
import { PlayerServiceService } from '../service/player-service.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {

  name : String | undefined
  class : String
  isEnemy : boolean

  constructor(private playerService : PlayerServiceService) { }

  ngOnInit(): void {
  }
  public onSubmit(){
    let player : User= {
      name : this.name,
      playerClass : this.class,
      
    }
    this.playerService.addAlly(this.player);
  }

}
