import {SNVAHtmlUnit} from "./SNVAHtmlUnit";
import {SNVAHtmlColor} from "./SNVAHtmlColor";

export class SNVAHtmlTextShadow
{
    xShadow : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    yShadow : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    blur    : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    color   : SNVAHtmlColor = new SNVAHtmlColor('');

    constructor(input:string)
    {
        let list = input.trim().split(' ').filter((s) => {return s != '';});
        if(list.length == 2)
        {
            this.xShadow = new SNVAHtmlUnit(list[0]);
            this.yShadow = new SNVAHtmlUnit(list[1]);
        }
        else if(list.length == 3)
        {
            if(this.isColor(list[0]))
            {
                this.xShadow = new SNVAHtmlUnit(list[1]);
                this.yShadow = new SNVAHtmlUnit(list[2]);
                this.color   = new SNVAHtmlColor(list[0]);
            }
            else
            {
                this.xShadow = new SNVAHtmlUnit(list[0]);
                this.yShadow = new SNVAHtmlUnit(list[1]);
                this.color   = new SNVAHtmlColor(list[2]);
            }
        }
        else if(list.length == 4)
        {
            if(this.isColor(list[0]))
            {
                this.color   = new SNVAHtmlColor(list[0]);
                this.xShadow = new SNVAHtmlUnit(list[1]);
                this.yShadow = new SNVAHtmlUnit(list[2]);
                this.blur    = new SNVAHtmlUnit(list[3]);
            }
            else
            {
                this.xShadow = new SNVAHtmlUnit(list[0]);
                this.yShadow = new SNVAHtmlUnit(list[1]);
                this.blur    = new SNVAHtmlUnit(list[2]);
                this.color   = new SNVAHtmlColor(list[3]);
            }
        }
    }

    isColor(input:string)
    {
        if(input.includes('#') || input.includes('rgb') || input.includes('rgba'))
        {
            return true;
        }
        return false;
    }

    toString()
    {
        if(this.xShadow.toString() !='' && this.yShadow.toString()!='')
        {
            let result = this.xShadow.toString() + ' ' + this.yShadow.toString();
            if(this.blur.toString() != '')
            {
                result = result + ' ' + this.blur.toString();
            }
            if(this.color.toString() != '')
            {
                result = result + ' ' + this.color.toString();
            }
            return result;
        }
        else
        {
            return '';
        }
    }
}
