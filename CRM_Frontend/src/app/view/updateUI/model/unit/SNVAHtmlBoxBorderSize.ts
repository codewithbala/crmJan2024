import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

/* not Support
    thin;
    medium;
    thick;
*/

export class SNVAHtmlBoxBorderSize
{
    topSize    : SNVAHtmlUnit = new SNVAHtmlUnit('');
    rightSize  : SNVAHtmlUnit = new SNVAHtmlUnit('');
    bottomSize : SNVAHtmlUnit = new SNVAHtmlUnit('');
    leftSize   : SNVAHtmlUnit = new SNVAHtmlUnit('');

    set(name:string, value:string)
    {
        let nameT = name.trim();
        if(nameT == 'border-width')
        {
            let tmp =  value.trim().split(' ').filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.topSize    = new SNVAHtmlUnit(tmp[0]);
                this.rightSize  = new SNVAHtmlUnit(tmp[0]);
                this.bottomSize = new SNVAHtmlUnit(tmp[0]);
                this.leftSize   = new SNVAHtmlUnit(tmp[0]);
            }
            else if(tmp.length == 2)
            {
                this.topSize    = new SNVAHtmlUnit(tmp[0]);
                this.rightSize  = new SNVAHtmlUnit(tmp[1]);
                this.bottomSize = new SNVAHtmlUnit(tmp[0]);
                this.leftSize   = new SNVAHtmlUnit(tmp[1]);
            }
            else if(tmp.length == 3)
            {
                this.topSize    = new SNVAHtmlUnit(tmp[0]);
                this.rightSize  = new SNVAHtmlUnit(tmp[1]);
                this.bottomSize = new SNVAHtmlUnit(tmp[2]);
                this.leftSize   = new SNVAHtmlUnit(tmp[1]);
            }
            else if(tmp.length == 4)
            {
                this.topSize    = new SNVAHtmlUnit(tmp[0]);
                this.rightSize  = new SNVAHtmlUnit(tmp[1]);
                this.bottomSize = new SNVAHtmlUnit(tmp[2]);
                this.leftSize   = new SNVAHtmlUnit(tmp[3]);
            }
        }
        else if(nameT == 'border-top-width')
        {
            this.topSize = new SNVAHtmlUnit(value.trim());
        }
        else if(nameT == 'border-right-width')
        {
            this.rightSize = new SNVAHtmlUnit(value.trim());
        }
        else if(nameT == 'border-bottom-width')
        {
            this.bottomSize = new SNVAHtmlUnit(value.trim());
        }
        else if(nameT == 'border-left-width')
        {
            this.leftSize = new SNVAHtmlUnit(value.trim());
        }
    }

    toString()
    {
        if(this.topSize.toString() != '' && this.rightSize.toString() != '' && this.bottomSize.toString() != '' && this.leftSize.toString() != '')
        {
            if(this.topSize.toString() == this.rightSize.toString() && this.topSize.toString() == this.bottomSize.toString() && this.topSize.toString() == this.leftSize.toString())
            {
                return 'border-width:' + this.topSize.toString() + ';';
            }
            else if(this.topSize.toString() == this.bottomSize.toString() && this.leftSize.toString() == this.rightSize.toString())
            {
                return 'border-width:' + this.topSize.toString() + ' ' + this.leftSize.toString() + ';';
            }
            else if(this.leftSize.toString() == this.rightSize.toString())
            {
                return 'border-width:' + this.topSize.toString() + ' ' + this.leftSize.toString() + ' ' + this.bottomSize.toString() +';';
            }
            else
            {
                return 'border-width:' + this.topSize.toString() + ' ' + this.rightSize.toString() + ' ' + this.bottomSize.toString() + ' ' + this.leftSize.toString() + ';';
            }
        }
        else
        {
            let result = '';
            if(this.topSize.toString() != '')
            {
                result = result + 'border-top-width:' + this.topSize + ";"
            }
            if(this.rightSize.toString() != '')
            {
                result = result + 'border-right-width:' + this.rightSize + ";"
            }
            if(this.bottomSize.toString() != '')
            {
                result = result + 'border-bottom-width:' + this.bottomSize + ";"
            }
            if(this.leftSize.toString() != '')
            {
                result = result + 'border-left-width:' + this.leftSize + ";"
            }
            return result;
        }
    }
}
