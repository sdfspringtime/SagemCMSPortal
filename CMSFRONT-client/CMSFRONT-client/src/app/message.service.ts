import { Injectable } from '@angular/core';
declare var SockJS: new (arg0: string) => any;
declare var Stomp: { over: (arg0: any) => any; };
@Injectable({
  providedIn: 'root'
})

export class MessageService {

  constructor() {
    this.initializeWebSocketConnection();
  }
  
  stompClient: any;
  public msg:string[]=[];
  initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:8080/websocket';
    console.log(serverUrl);
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    // tslint:disable-next-line:only-arrow-functions
    this.stompClient.connect({}, function(frame:any) {
      that.stompClient.subscribe('/topic/messages', (message:any) => {
        if (message.body) {
          that.msg.push(JSON.stringify(JSON.parse(message.body),null,2));
        }
      });
    });
  }
}
