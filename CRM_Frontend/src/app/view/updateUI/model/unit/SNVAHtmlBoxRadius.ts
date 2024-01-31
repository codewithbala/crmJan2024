import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

/**/


export class SNVAHtmlBoxRadius
{
    topLeft     :SNVAHtmlUnit = new SNVAHtmlUnit('0px');
    topRight    :SNVAHtmlUnit = new SNVAHtmlUnit('0px');
    bottomLeft  :SNVAHtmlUnit = new SNVAHtmlUnit('0px');
    bottomRight :SNVAHtmlUnit = new SNVAHtmlUnit('0px');
    stringValue :string = '';

    set(pos:string, size:string)
    {
        if(pos.includes('border-radius'))
        {
            if(!size.includes('/'))
            {
                let tmp = size.trim().split(" ").filter((s) => {return s != '';});
                if(tmp.length == 1)
                {
                    this.topLeft     = new SNVAHtmlUnit(tmp[0]);
                    this.topRight    = new SNVAHtmlUnit(tmp[0]);
                    this.bottomRight = new SNVAHtmlUnit(tmp[0]);
                    this.bottomLeft  = new SNVAHtmlUnit(tmp[0]);
                }
                else if(tmp.length == 2)
                {
                    this.topLeft     = new SNVAHtmlUnit(tmp[0]);
                    this.topRight    = new SNVAHtmlUnit(tmp[1]);
                    this.bottomRight = new SNVAHtmlUnit(tmp[0]);
                    this.bottomLeft  = new SNVAHtmlUnit(tmp[1]);
                }
                else if(tmp.length == 3)
                {
                    this.topLeft     = new SNVAHtmlUnit(tmp[0]);
                    this.topRight    = new SNVAHtmlUnit(tmp[1]);
                    this.bottomRight = new SNVAHtmlUnit(tmp[1]);
                    this.bottomLeft  = new SNVAHtmlUnit(tmp[2]);
                }
                else if(tmp.length == 4)
                {
                    this.topLeft     = new SNVAHtmlUnit(tmp[0]);
                    this.topRight    = new SNVAHtmlUnit(tmp[1]);
                    this.bottomRight = new SNVAHtmlUnit(tmp[2]);
                    this.bottomLeft  = new SNVAHtmlUnit(tmp[3]);
                }
            }
            else
            {
                this.stringValue = this.stringValue + pos + ':' + size + ';';
            }
        }
        else if(pos.includes('border-top-left-radius'))
        {
            let tmp = size.trim().split(" ").filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.topLeft     = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.stringValue = this.stringValue + pos + ':' + size + ';';
            }
        }
        else if(pos.includes('border-top-right-radius'))
        {
            let tmp = size.trim().split(" ").filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.topRight     = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.stringValue = this.stringValue + pos + ':' + size + ';';
            }
        }
        else if(pos.includes('border-bottom-right-radius'))
        {
            let tmp = size.trim().split(" ").filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.bottomRight     = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.stringValue = this.stringValue + pos + ':' + size + ';';
            }
        }
        else if(pos.includes('border-bottom-left-radius'))
        {
            let tmp = size.trim().split(" ").filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.bottomLeft     = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.stringValue = this.stringValue + pos + ':' + size + ';';
            }
        }
    }

    toString()
    {
        if(this.stringValue != '')
        {
            return this.stringValue;
        }
        else if( this.topLeft.toString() != ''       &&
            this.topLeft.size != '0'            &&
            this.topLeft.equal(this.topRight)   &&
            this.topLeft.equal(this.bottomLeft) &&
            this.topLeft.equal(this.bottomRight))
        {
            return "border-radius:" + this.topLeft.toString() + ';';
        }
        else if(this.topLeft.size == this.topRight.size    &&
                this.topLeft.size == this.bottomLeft.size  &&
                this.topLeft.size == this.bottomRight.size &&
                this.topLeft.size == '0')
        {
            return '';
        }
        else
        {
            return "border-radius:" + this.topLeft.toString() + ' '
                                    + this.topRight.toString() + ' '
                                    + this.bottomRight.toString() + ' '
                                    + this.bottomLeft + ';';
        }
    }

}
