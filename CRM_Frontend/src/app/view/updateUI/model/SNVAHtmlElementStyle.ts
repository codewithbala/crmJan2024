import {SNVAHtmlColor} from "./unit/SNVAHtmlColor";
import {SNVAHtmlBoxPosition} from "./unit/SNVAHtmlBoxPosition";
import {SNVAHtmlBoxRadius} from "./unit/SNVAHtmlBoxRadius";
import {SNVAHtmlBoxBorder} from "./unit/SNVAHtmlBoxBorder";
import {SNVAHtmlBoxShadow} from "./unit/SNVAHtmlBoxShadow";
import {SNVAHtmlTextFont} from "./unit/SNVAHtmlTextFont";
import {SNVAHtmlTextPosition} from "./unit/SNVAHtmlTextPosition";
import {SNVAHtmlBoxSize} from "./unit/SNVAHtmlBoxSize";
import {SNVAHtmlTextShadow} from "./unit/SNVAHtmlTextShadow";

export class SNVAHtmlElementStyle
{
    boxColor    : SNVAHtmlColor        = new SNVAHtmlColor('');
    boxPosition : SNVAHtmlBoxPosition  = new SNVAHtmlBoxPosition();
    boxSize     : SNVAHtmlBoxSize      = new SNVAHtmlBoxSize();
    boxBorder   : SNVAHtmlBoxBorder    = new SNVAHtmlBoxBorder();
    boxRadius   : SNVAHtmlBoxRadius    = new SNVAHtmlBoxRadius();
    boxShadow   : SNVAHtmlBoxShadow[]  = [];
    textColor   : SNVAHtmlColor        = new SNVAHtmlColor('');
    textFont    : SNVAHtmlTextFont     = new SNVAHtmlTextFont();
    textPosition: SNVAHtmlTextPosition = new SNVAHtmlTextPosition();
    textShadow  : SNVAHtmlTextShadow[]  = [];
    others      : string;

    constructor(input:string)
    {
        let styleList = input.split(';');
        styleList.forEach(s =>
        {
            let pairs = s.split(':');
            if(pairs[0].trim() == 'background-color')
            {
                this.boxColor = new SNVAHtmlColor(pairs[1]);
            }
            else if(pairs[0].trim() == 'color')
            {
                this.textColor = new SNVAHtmlColor(pairs[1]);
            }
            else if(pairs[0].includes('border') && pairs[0].includes('radius'))
            {
                this.boxRadius.set(pairs[0], pairs[1]);
            }
            else if(pairs[0].includes('border') && !pairs[0].includes('radius'))
            {
                this.boxBorder.set(pairs[0], pairs[1]);
            }
            else if(pairs[0].includes('width') || pairs[0].includes('height'))
            {
                this.boxSize.set(pairs[0],pairs[1]);
            }
            else if(pairs[0].includes('margin'))
            {
                this.boxPosition.set(pairs[0], pairs[1]);
            }
            else if(pairs[0].includes('box-shadow'))
            {
                let tmp = pairs[1].split(',');
                tmp.forEach(s => {
                    this.boxShadow.push(new SNVAHtmlBoxShadow(s));
                })
            }
            else if(pairs[0].includes('font') || pairs[0].includes('text-align'))
            {
               this.textFont.set(pairs[0], pairs[1]);
            }
            else if(pairs[0].includes('padding'))
            {
                this.textPosition.set(pairs[0], pairs[1]);
            }
            else if(pairs[0].includes('text-shadow'))
            {
                let tmp = pairs[1].split(',');
                tmp.forEach(s => {
                    this.textShadow.push(new SNVAHtmlTextShadow(s));
                })
            }
            else
            {
                this.others = this.others + pairs[0] + ':' + pairs[1] + ';';
            }
        })
    }

    toString()
    {
        let result = '';

        if(this.boxColor!=undefined && this.boxColor.aChannel > 0)
        {
            result = result + 'background-color:' + this.boxColor.toString() + ';'
        }

        result = result
            + this.boxSize.toString()
            + this.boxPosition.toString()
            + this.boxBorder.toString()
            + this.boxRadius.toString();

        if(this.boxShadow.length > 0)
        {
            let shadowList = '';

            for(let i = 0; i < this.boxShadow.length; i++)
            {
                shadowList = shadowList + this.boxShadow[i].toString();
                if(i != this.boxShadow.length -1)
                {
                    shadowList = shadowList + ',';
                }
            }
            if(shadowList != '')
            {
                result = result + 'box-shadow:' + shadowList + ';';
            }
        }

        if(this.textColor!=undefined && this.textColor.aChannel > 0)
        {
            result = result + 'color:' + this.textColor.toString() + ';';
        }

        result = result + this.textFont.toString() + this.textPosition;

        if(this.textShadow.length > 0)
        {
            let shadowList = '';

            for(let i = 0; i < this.textShadow.length; i++)
            {
                shadowList = shadowList + this.textShadow[i].toString();
                if(i != this.textShadow.length -1)
                {
                    shadowList = shadowList + ',';
                }
            }
            if(shadowList != '')
            {
                result = result + 'text-shadow:' + shadowList + ';';
            }
        }
        return  result;
    }

}
