import { roles } from "./roles";

export class Useraudit {
  

    constructor(
    private roles:string,
   
    private email:string,
    private username:string,
    private revtype:number,
    private revisionauthor:string,
    private revisiondate:Date,
){}
}