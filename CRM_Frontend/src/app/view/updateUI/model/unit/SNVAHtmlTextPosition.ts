import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

export class SNVAHtmlTextPosition
{
    paddingTop    : SNVAHtmlUnit = new SNVAHtmlUnit('');
    paddingRight  : SNVAHtmlUnit = new SNVAHtmlUnit('');
    paddingBottom : SNVAHtmlUnit = new SNVAHtmlUnit('');
    paddingLeft   : SNVAHtmlUnit = new SNVAHtmlUnit('');

    constructor()
    {}

    set(name:string, value:string)
    {
        if(name.includes('padding-top'))
        {
            this.paddingTop = new SNVAHtmlUnit(value);
        }
        else if(name.includes('padding-right'))
        {
            this.paddingRight = new SNVAHtmlUnit(value);
        }
        else if(name.includes('padding-bottom'))
        {
            this.paddingBottom = new SNVAHtmlUnit(value);
        }
        else if(name.includes('padding-left'))
        {
            this.paddingLeft = new SNVAHtmlUnit(value);
        }
        else if(name.includes('padding'))
        {
            let tmp = value.trim().split(" ").filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                console.log(value);
                console.log(tmp);
                this.paddingTop    = new SNVAHtmlUnit(tmp[0]);
                this.paddingRight  = new SNVAHtmlUnit(tmp[0]);
                this.paddingBottom = new SNVAHtmlUnit(tmp[0]);
                this.paddingLeft   = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                console.log(value);
                console.log(tmp);
                this.paddingTop    = new SNVAHtmlUnit(tmp[0]);
                this.paddingRight  = new SNVAHtmlUnit(tmp[1]);
                this.paddingBottom = new SNVAHtmlUnit(tmp[0]);
                this.paddingLeft   = new SNVAHtmlUnit(tmp[1]);
            }
            else if(tmp.length == 3)
            {
                console.log(value);
                console.log(tmp);
                this.paddingTop    = new SNVAHtmlUnit(tmp[0]);
                this.paddingRight  = new SNVAHtmlUnit(tmp[1]);
                this.paddingBottom = new SNVAHtmlUnit(tmp[2]);
                this.paddingLeft   = new SNVAHtmlUnit(tmp[1]);
            }
            else if(tmp.length == 4)
            {
                console.log(value);
                console.log(tmp);
                this.paddingTop    = new SNVAHtmlUnit(tmp[0]);
                this.paddingRight  = new SNVAHtmlUnit(tmp[1]);
                this.paddingBottom = new SNVAHtmlUnit(tmp[2]);
                this.paddingLeft   = new SNVAHtmlUnit(tmp[3]);
            }
        }
    }

    toString()
    {
        if(this.paddingLeft.toString() != '' && this.paddingRight.toString() != '' && this.paddingTop.toString() != '' && this.paddingBottom.toString() != '')
        {
            if(this.paddingTop.equal(this.paddingRight) && this.paddingTop.equal(this.paddingBottom) && this.paddingTop.equal(this.paddingLeft)  )
            {
                return "padding:" + this.paddingTop.toString() + ";";
            }
            else if(this.paddingTop.equal(this.paddingBottom) && this.paddingLeft.equal(this.paddingRight))
            {
                return "padding:" + this.paddingTop.toString() + ' ' + this.paddingLeft+ ";";
            }
            else if(this.paddingLeft.equal(this.paddingRight))
            {
                return "padding:" + this.paddingTop.toString() + ' ' + this.paddingLeft + ' ' + this.paddingBottom +  ";";
            }
            else
            {
                return "padding:" + this.paddingTop.toString() + ' ' + this.paddingRight + ' ' + this.paddingBottom + ' ' + this.paddingLeft +  ";";
            }
        }
        else
        {
            let result = ''
            if(this.paddingTop.toString() != '')
            {
                result = result + 'padding-Top:' + this.paddingTop + ';'
            }
            if(this.paddingRight.toString() != '')
            {
                result = result + 'padding-right:' + this.paddingRight + ';'
            }
            if(this.paddingBottom.toString() != '')
            {
                result = result + 'padding-bottom:' + this.paddingBottom + ';'
            }
            if(this.paddingLeft.toString() != '')
            {
                result = result + 'padding-left:' + this.paddingLeft + ';'
            }
            return result;
        }

    }

}
