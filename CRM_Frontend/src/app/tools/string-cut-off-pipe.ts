import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'stringCutOff'
})
export class StringCutOffPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    let newStr = value;
    let defaultLength = 12;
    let strEnLen = 0;
    let strCnLen = 0;
    let strLength = args ? args * 2 : defaultLength * 2;
    let cutIndex = 0;
    for (let i = 0; i < value.length; i++) {
      if (value.charCodeAt(i) <= 255) { //如果是汉字，则字符串长度加2
        strEnLen++;
      } else {
        strCnLen += 2
      }
      if ((strEnLen + strCnLen) >= strLength) {
        cutIndex = i;
        break;
      }
    }
    if (value && strEnLen + strCnLen >= strLength) {
      newStr = value.substring(0, cutIndex) + '...'
    };
    return newStr;
  }

}
