import {SNVAHtmlUnit} from "./SNVAHtmlUnit";
import {SNVAHtmlColor} from "./SNVAHtmlColor";

export class SNVAHtmlBoxShadow
{
    xShadow : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    yShadow : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    blur    : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    spread  : SNVAHtmlUnit  = new SNVAHtmlUnit('');
    color   : SNVAHtmlColor = new SNVAHtmlColor('');
    inset   : boolean = false;

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
            else if (list[0] == 'inset')
            {
                this.xShadow = new SNVAHtmlUnit(list[1]);
                this.yShadow = new SNVAHtmlUnit(list[2]);
                this.inset   = true;
            }
            else
            {
                this.xShadow = new SNVAHtmlUnit(list[0]);
                this.yShadow = new SNVAHtmlUnit(list[1]);
                if(this.isColor(list[2]))
                {
                    this.color   = new SNVAHtmlColor(list[2]);
                }
                else if (list[2] == 'inset')
                {
                    this.inset = true;
                }
                else
                {
                    this.blur = new SNVAHtmlUnit(list[2]);
                }
            }
        }
        else if(list.length == 4)
        {
            if(list[0] == 'inset')
            {
                this.inset = true;
                if(this.isColor(list[1]))
                {
                    this.color = new SNVAHtmlColor(list[1]);
                }
                else
                {
                    this.xShadow = new SNVAHtmlUnit(list[1]);
                    this.yShadow = new SNVAHtmlUnit(list[2]);
                    if(this.isColor(list[3]))
                    {
                        this.color = new SNVAHtmlColor(list[3]);
                    }
                    else
                    {
                        this.blur    = new SNVAHtmlUnit(list[3]);
                    }
                }
            }
            else if(this.isColor(list[0]))
            {
                this.color   = new SNVAHtmlColor(list[0]);
                this.xShadow = new SNVAHtmlUnit(list[1]);
                this.yShadow = new SNVAHtmlUnit(list[2]);
                if(list[3] != 'inset')
                {
                    this.blur    = new SNVAHtmlUnit(list[3]);
                }
                else
                {
                    this.inset = true;
                }
            }
            else {
                this.xShadow = new SNVAHtmlUnit(list[0]);
                this.yShadow = new SNVAHtmlUnit(list[1]);
                if (this.isColor(list[2]))
                {
                    this.color = new SNVAHtmlColor(list[2]);
                    if (list[3] == 'inset')
                    {
                        this.inset = true;
                    }
                    else // error input, reset shadow.
                    {
                        this.xShadow = new SNVAHtmlUnit('');
                        this.yShadow = new SNVAHtmlUnit('');
                        this.color = new SNVAHtmlColor('');
                        this.inset = false;
                    }
                }
                else
                {
                    this.blur = new SNVAHtmlUnit(list[2]);
                    if (list[3] == 'inset')
                    {
                        this.inset = true;
                    }
                    else if (this.isColor(list[3]))
                    {
                        this.color = new SNVAHtmlColor(list[3]);
                    }
                    else
                    {
                        this.spread = new SNVAHtmlUnit(list[3]);
                    }
                }
            }
        }
        else if(list.length == 5)
        {
            if(list[0] == 'inset')
            {
                this.inset = true;
                if(this.isColor(list[1]))
                {
                    this.color   = new SNVAHtmlColor(list[1]);
                    this.xShadow = new SNVAHtmlUnit(list[2]);
                    this.yShadow = new SNVAHtmlUnit(list[3]);
                    this.blur    = new SNVAHtmlUnit(list[4]);
                }
                else
                {
                    this.xShadow = new SNVAHtmlUnit(list[1]);
                    this.yShadow = new SNVAHtmlUnit(list[2]);
                    this.blur    = new SNVAHtmlUnit(list[3]);
                    if(this.isColor(list[4]))
                    {
                        this.color   = new SNVAHtmlColor(list[4]);
                    }
                    else
                    {
                        this.spread = new SNVAHtmlUnit(list[4]);
                    }
                }
            }
            else if(this.isColor(list[0]))
            {
                this.color   = new SNVAHtmlColor(list[0]);
                this.xShadow = new SNVAHtmlUnit(list[1]);
                this.yShadow = new SNVAHtmlUnit(list[2]);
                this.blur    = new SNVAHtmlUnit(list[3]);
                if(list[4] == 'inset')
                {
                    this.inset = true;
                }
                else
                {
                    this.spread  = new SNVAHtmlUnit(list[4]);
                }
            }
            else
            {
                this.xShadow = new SNVAHtmlUnit(list[0]);
                this.yShadow = new SNVAHtmlUnit(list[1]);
                this.blur    = new SNVAHtmlUnit(list[2]);
                if(this.isColor(list[3]))
                {
                    this.color = new SNVAHtmlColor(list[3]);
                    if(list[4] == 'inset')
                    {
                        this.inset = true;
                    }
                    else // error input
                    {
                        this.xShadow = new SNVAHtmlUnit('');
                        this.yShadow = new SNVAHtmlUnit('');
                        this.blur    = new SNVAHtmlUnit('');
                        this.color = new SNVAHtmlColor('');
                        this.inset = false;
                    }
                }
                else
                {
                    this.spread = new SNVAHtmlUnit(list[3]);
                    if(this.isColor(list[4]))
                    {
                        this.color = new SNVAHtmlColor(list[4]);
                    }
                    else if(list[4] == 'inset')
                    {
                        this.inset = true;
                    }
                    else // error input
                    {
                        this.xShadow = new SNVAHtmlUnit('');
                        this.yShadow = new SNVAHtmlUnit('');
                        this.blur    = new SNVAHtmlUnit('');
                        this.spread  = new SNVAHtmlUnit('');
                        this.color   = new SNVAHtmlColor('');
                        this.inset   = false;
                    }
                }
            }
        }
        else if(list.length == 6)
        {
            console.log("has 6 input values" + list);
            if(list[0] == 'inset')
            {
                this.inset   = true;
                if(this.isColor(list[1]))
                {
                    this.color   = new SNVAHtmlColor(list[1]);
                    this.xShadow = new SNVAHtmlUnit(list[2]);
                    this.yShadow = new SNVAHtmlUnit(list[3]);
                    this.blur    = new SNVAHtmlUnit(list[4]);
                    this.spread  = new SNVAHtmlUnit(list[5]);
                }
                else
                {
                    this.xShadow = new SNVAHtmlUnit(list[1]);
                    this.yShadow = new SNVAHtmlUnit(list[2]);
                    this.blur    = new SNVAHtmlUnit(list[3]);
                    this.spread  = new SNVAHtmlUnit(list[4]);
                    this.color   = new SNVAHtmlColor(list[5]);
                }
            }
            else if(this.isColor(list[0]))
            {
                this.color   = new SNVAHtmlColor(list[0]);
                this.xShadow = new SNVAHtmlUnit(list[1]);
                this.yShadow = new SNVAHtmlUnit(list[2]);
                this.blur    = new SNVAHtmlUnit(list[3]);
                this.spread  = new SNVAHtmlUnit(list[4]);
                if(list[5] == 'inset')
                {
                    this.inset   = true;
                }
                else // error input
                {
                    this.xShadow = new SNVAHtmlUnit('');
                    this.yShadow = new SNVAHtmlUnit('');
                    this.blur    = new SNVAHtmlUnit('');
                    this.spread  = new SNVAHtmlUnit('');
                    this.color   = new SNVAHtmlColor('');
                    this.inset   = false;
                }
            }
            else
            {
                this.xShadow = new SNVAHtmlUnit(list[0]);
                this.yShadow = new SNVAHtmlUnit(list[1]);
                this.blur    = new SNVAHtmlUnit(list[2]);
                this.spread  = new SNVAHtmlUnit(list[3]);
                if(this.isColor(list[4]))
                {
                    this.color   = new SNVAHtmlColor(list[4]);
                    if(list[5] == 'inset')
                    {
                        this.inset = true;
                    }
                    else
                    {
                        this.xShadow = new SNVAHtmlUnit('');
                        this.yShadow = new SNVAHtmlUnit('');
                        this.blur    = new SNVAHtmlUnit('');
                        this.spread  = new SNVAHtmlUnit('');
                        this.color   = new SNVAHtmlColor('');
                        this.inset   = false;
                    }
                }
                else // error input
                {
                    this.xShadow = new SNVAHtmlUnit('');
                    this.yShadow = new SNVAHtmlUnit('');
                    this.blur    = new SNVAHtmlUnit('');
                    this.spread  = new SNVAHtmlUnit('');
                    this.color   = new SNVAHtmlColor('');
                    this.inset   = false;
                }
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
            if(this.spread.toString() != '')
            {
                result = result + ' ' + this.spread.toString();
            }
            if(this.color.toString() != '')
            {
                result = result + ' ' + this.color.toString();
            }
            if(this.inset)
            {
                result = result + ' inset';
            }
            return result;
        }
        else
        {
            return '';
        }
    }

}
