import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'revType'
})
export class RevTypePipe implements PipeTransform {

  transform(revnumber : number, ): string {
    switch(revnumber){
      case 0 : return "Creation"; 
      case 1 : return "Update" ; 
      case 2 : return "Delete" ; 
      default : return "undefined"
    }
  }

}
