export class Machaudit {
    constructor (
        private rev :number,
        private revtype :number,
        private description : string,
       private  name : string,
       private  revisiondate :Date,
       private  revisionauthor :string,
       private fese:boolean,
       private status:boolean,
       private line_id:number,
       private typemach:string
       ){}
 
}
