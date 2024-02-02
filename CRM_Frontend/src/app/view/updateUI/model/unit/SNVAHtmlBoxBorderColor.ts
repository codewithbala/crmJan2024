import {SNVAHtmlColor} from "./SNVAHtmlColor";
import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

export class SNVAHtmlBoxBorderColor
{
    topColor    : SNVAHtmlColor = new SNVAHtmlColor('');
    rightColor  : SNVAHtmlColor = new SNVAHtmlColor('');
    bottomColor : SNVAHtmlColor = new SNVAHtmlColor('');
    leftColor   : SNVAHtmlColor = new SNVAHtmlColor('');

    set(name:string, value:string)
    {
        let nameT = name.trim();
        if(nameT == 'border-color')
        {
            let tmp =  value.trim().split(' ').filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.topColor    = new SNVAHtmlColor(tmp[0]);
                this.rightColor  = new SNVAHtmlColor(tmp[0]);
                this.bottomColor = new SNVAHtmlColor(tmp[0]);
                this.leftColor   = new SNVAHtmlColor(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.topColor    = new SNVAHtmlColor(tmp[0]);
                this.rightColor  = new SNVAHtmlColor(tmp[1]);
                this.bottomColor = new SNVAHtmlColor(tmp[0]);
                this.leftColor   = new SNVAHtmlColor(tmp[1]);
            }
            else if(tmp.length == 3)
            {
                this.topColor    = new SNVAHtmlColor(tmp[0]);
                this.rightColor  = new SNVAHtmlColor(tmp[1]);
                this.bottomColor = new SNVAHtmlColor(tmp[2]);
                this.leftColor   = new SNVAHtmlColor(tmp[1]);
            }
            else if(tmp.length == 4)
            {
                this.topColor    = new SNVAHtmlColor(tmp[0]);
                this.rightColor  = new SNVAHtmlColor(tmp[1]);
                this.bottomColor = new SNVAHtmlColor(tmp[2]);
                this.leftColor   = new SNVAHtmlColor(tmp[3]);
            }
        }
        else if(nameT == 'border-top-color')
        {
            this.topColor = new SNVAHtmlColor(value.trim());
        }
        else if(nameT == 'border-right-color')
        {
            this.rightColor = new SNVAHtmlColor(value.trim());
        }
        else if(nameT == 'border-bottom-color')
        {
            this.bottomColor = new SNVAHtmlColor(value.trim());
        }
        else if(nameT == 'border-left-color')
        {
            this.leftColor = new SNVAHtmlColor(value.trim());
        }
    }

    toString()
    {
        if(this.topColor.toString() != '' && this.rightColor.toString() != '' && this.bottomColor.toString() != '' && this.leftColor.toString() != '')
        {
            if(this.topColor.toString() == this.rightColor.toString() && this.topColor.toString() == this.bottomColor.toString() && this.topColor.toString() == this.leftColor.toString())
            {
                return 'border-color:' + this.topColor.toString() + ';';
            }
            else if(this.topColor.toString() == this.bottomColor.toString() && this.leftColor.toString() == this.rightColor.toString())
            {
                return 'border-color:' + this.topColor.toString() + ' ' + this.leftColor.toString() + ';';
            }
            else if(this.leftColor.toString() == this.rightColor.toString())
            {
                return 'border-color:' + this.topColor.toString() + ' ' + this.leftColor.toString() + ' ' + this.bottomColor.toString() +';';
            }
            else
            {
                return 'border-color:' + this.topColor.toString() + ' ' + this.rightColor.toString() + ' ' + this.bottomColor.toString() + ' ' + this.leftColor.toString() + ';';
            }
        }
        else
        {
            let result = '';
            if(this.topColor.toString() != '')
            {
                result = result + 'border-top-color:' + this.topColor + ";"
            }
            if(this.rightColor.toString() != '')
            {
                result = result + 'border-right-color:' + this.rightColor + ";"
            }
            if(this.bottomColor.toString() != '')
            {
                result = result + 'border-bottom-color:' + this.bottomColor + ";"
            }
            if(this.leftColor.toString() != '')
            {
                result = result + 'border-left-color:' + this.leftColor + ";"
            }
            return result;
        }

    }
}
