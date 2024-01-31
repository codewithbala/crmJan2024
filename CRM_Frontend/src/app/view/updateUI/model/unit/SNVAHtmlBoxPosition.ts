import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

export class SNVAHtmlBoxPosition
{
    marginTop    : SNVAHtmlUnit = new SNVAHtmlUnit('');
    marginRight  : SNVAHtmlUnit = new SNVAHtmlUnit('');
    marginBottom : SNVAHtmlUnit = new SNVAHtmlUnit('');
    marginLeft   : SNVAHtmlUnit = new SNVAHtmlUnit('');

    constructor()
    {}

    set(name:string, value:string)
    {
        if(name.includes('margin-top'))
        {
            this.marginTop = new SNVAHtmlUnit(value);
        }
        else if(name.includes('margin-right'))
        {
            this.marginRight = new SNVAHtmlUnit(value);
        }
        else if(name.includes('margin-bottom'))
        {
            this.marginBottom = new SNVAHtmlUnit(value);
        }
        else if(name.includes('margin-left'))
        {
            this.marginLeft = new SNVAHtmlUnit(value);
        }
        else if(name.includes('margin'))
        {
            let tmp = value.trim().split(" ").filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.marginTop    = new SNVAHtmlUnit(tmp[0]);
                this.marginRight  = new SNVAHtmlUnit(tmp[0]);
                this.marginBottom = new SNVAHtmlUnit(tmp[0]);
                this.marginLeft   = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.marginTop    = new SNVAHtmlUnit(tmp[0]);
                this.marginRight  = new SNVAHtmlUnit(tmp[1]);
                this.marginBottom = new SNVAHtmlUnit(tmp[0]);
                this.marginLeft   = new SNVAHtmlUnit(tmp[1]);
            }
            else if(tmp.length == 3)
            {
                this.marginTop    = new SNVAHtmlUnit(tmp[0]);
                this.marginRight  = new SNVAHtmlUnit(tmp[1]);
                this.marginBottom = new SNVAHtmlUnit(tmp[2]);
                this.marginLeft   = new SNVAHtmlUnit(tmp[1]);
            }
            else if(tmp.length == 4)
            {
                this.marginTop    = new SNVAHtmlUnit(tmp[0]);
                this.marginRight  = new SNVAHtmlUnit(tmp[1]);
                this.marginBottom = new SNVAHtmlUnit(tmp[2]);
                this.marginLeft   = new SNVAHtmlUnit(tmp[3]);
            }
        }
    }

    toString()
    {
        if(this.marginLeft.toString() != '' && this.marginRight.toString() != '' && this.marginTop.toString() != '' && this.marginBottom.toString() != '')
        {
            if(this.marginTop.equal(this.marginRight) && this.marginTop.equal(this.marginBottom) && this.marginTop.equal(this.marginLeft)  )
            {
                return "margin:" + this.marginTop.toString() + ";";
            }
            else if(this.marginTop.equal(this.marginBottom) && this.marginLeft.equal(this.marginRight))
            {
                return "margin:" + this.marginTop.toString() + ' ' + this.marginLeft+ ";";
            }
            else if(this.marginLeft.equal(this.marginRight))
            {
                return "margin:" + this.marginTop.toString() + ' ' + this.marginLeft + ' ' + this.marginBottom +  ";";
            }
            else
            {
                return "margin:" + this.marginTop.toString() + ' ' + this.marginRight + ' ' + this.marginBottom + ' ' + this.marginLeft +  ";";
            }
        }
        else
        {
            let result = ''
            if(this.marginTop.toString() != '')
            {
                result = result + 'margin-Top:' + this.marginTop + ';'
            }
            if(this.marginRight.toString() != '')
            {
                result = result + 'margin-right:' + this.marginRight + ';'
            }
            if(this.marginBottom.toString() != '')
            {
                result = result + 'margin-bottom:' + this.marginBottom + ';'
            }
            if(this.marginLeft.toString() != '')
            {
                result = result + 'margin-left:' + this.marginLeft + ';'
            }
            return result;
        }
    }
}
