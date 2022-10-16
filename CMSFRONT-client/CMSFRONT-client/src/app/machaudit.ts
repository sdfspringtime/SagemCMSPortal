import { Lineprod } from "./lineprod";

export class Machaudit {
    constructor (
        private rev :number,
        private revtype :number,
        
        private typemach:string,
        private description:string,
        private allocated:boolean,
        private status:boolean,
        private line:Lineprod,
        private revisionauthor:string,
        private revisiondate:Date,
        private  name:string,
        private fese:boolean,
       ){}
 
}
