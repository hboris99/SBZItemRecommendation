import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/Player';

@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {

  constructor(private http: HttpClient) { }

  public addAlly(user : any){
    return this.http.post<User>('recommend/addAlly', user);
  }
  public addEnemy(user : any){
    return this.http.post<User>('recommend/addEnemy', user);
  }

  public buyItem(user : any, id: string, name: string){
    return this.http.put<User>('recommend/enemy/' + name + '/purchase/' + id, user);
  }


}
