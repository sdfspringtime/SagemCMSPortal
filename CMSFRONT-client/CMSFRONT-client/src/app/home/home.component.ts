import { Component, OnInit } from '@angular/core';
import { MessageService } from '../message.service';
import { TokenStorageService } from '../_services/token-storage.service';
declare var SockJS: new (arg0: string) => any;
declare var Stomp: { over: (arg0: any) => any; };
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'WebSocketChatRoom';
  greetings: string[] = [];
  disabled = true;
  newmessage: string;
  private stompClient = null;
   username=this.tserv.getUser().username;
 
  setConnected(connected: boolean) {
    this.disabled = !connected;
    if (connected) {
      this.greetings = [];
    }
  }
  connect() {
    const socket = new SockJS('http://localhost:8080/testchat');
    this.stompClient = Stomp.over(socket);
    const _this = this;
    this.stompClient.connect({}, function (frame:any) {
      console.log('Connected: ' + frame);
      _this.stompClient.subscribe('/start/initial', function(hello:any){
        console.log("after send\n"+JSON.parse(hello.body));
        _this.showMessage(JSON.parse(hello.body));
      });
   });
  }
  sendMessage() {
    console.log("before send\n"+this.newmessage)

    this.stompClient.send(
      '/app/resume',
      {},
      JSON.stringify(`${this.username} : ${this.newmessage}`)
    );
    this.newmessage = "";
    console.log(this.greetings);
  }
  showMessage(message:any) {
    
    this.greetings.push(message);
    
  }
  
  content?: string;
  constructor(private userService: UserService,public msserv: MessageService,public tserv:TokenStorageService) { }

  ngOnInit(): void {
    this.connect();
    const username=this.tserv.getUser().username;
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }
}