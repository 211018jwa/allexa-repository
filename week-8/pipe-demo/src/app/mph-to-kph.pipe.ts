import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mphToKph'
})
export class MphToKphPipe implements PipeTransform {

  transform(value: number, reversed: boolean = false): number {
    if(reversed) {
      return value * 0.62137;
    } else {
      return value * 1.60934;
    }
  }

}
