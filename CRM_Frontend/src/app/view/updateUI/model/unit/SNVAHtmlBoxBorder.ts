import {SNVAHtmlBoxBorderStyle} from "./SNVAHtmlBoxBorderStyle";
import {SNVAHtmlBoxBorderColor} from "./SNVAHtmlBoxBorderColor";
import {SNVAHtmlBoxBorderSize} from "./SNVAHtmlBoxBorderSize";
import {isCI} from "@angular/cli/src/utilities/environment-options";

export class SNVAHtmlBoxBorder
{
    borderStyle : SNVAHtmlBoxBorderStyle = new SNVAHtmlBoxBorderStyle();
    borderColor : SNVAHtmlBoxBorderColor = new SNVAHtmlBoxBorderColor();
    borderSize  : SNVAHtmlBoxBorderSize  = new SNVAHtmlBoxBorderSize();

    constructor() {
    }

    set(name:string, value:string)
    {
        if(name.includes('border'))
        {
            if(name.includes('style'))
            {
                this.borderStyle.set(name, value);
            }
            else if(name.includes('color'))
            {
                this.borderColor.set(name, value);
            }
            else if(name.includes('width'))
            {
                this.borderSize.set(name, value);
            }
            else if(name.trim() == 'border' || name.trim() == 'border-top' || name.trim() == 'border-right' || name.trim() == 'border-bottom' || name.trim() == 'border-left')
            {
                this.borderSet(name.trim(), value);
            }
        }

    }

    borderSet(name:string,value:string)
    {
        let valueList = value.trim().split(' ').filter((s) => {return s != '';});
        if(valueList.length == 1)
        {
            this.borderStyle.set(name+ '-style', valueList[0]);
        }
        else if(valueList.length == 2 || valueList.length == 3)
        {
            valueList.forEach(s =>
            {
                if(this.isColor(s))
                {
                    this.borderColor.set(name+ '-color', s);
                }
                else if(this.isSize(s))
                {
                    this.borderSize.set(name+ '-width', s);
                }
                else
                {
                    this.borderStyle.set(name+ '-style', s);
                }
            })
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

    isSize(input:string)
    {
        if(!!input.match(/\d/g))
        {
            return true;
        }
        return false;
    }

    toString()
    {
        return this.borderStyle.toString() + this.borderColor.toString() + this.borderSize.toString();
    }
}
