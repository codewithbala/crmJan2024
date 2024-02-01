import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

export class SNVAHtmlTextFont
{
    public fontFamily = '';
    public fontSize:SNVAHtmlUnit = new SNVAHtmlUnit('');
    public fontStyle = 'normal';
    public fontWeight=  'normal';
    public textAlign = '';

    set(name:string, value:string)
    {
        if(name.includes('font-family'))
        {
            this.fontFamily = value;
        }
        else if(name.includes('font-size'))
        {
            this.fontSize = new SNVAHtmlUnit(value);
        }
        else if(name.includes('font-style'))
        {
            this.fontStyle = value;
        }
        else if(name.includes('font-weight'))
        {
            this.fontWeight = value;
        }
        else if(name.includes('text-align'))
        {
            this.textAlign = value;
        }
    }

    setFontFamily(input:string)
    {
        this.fontFamily = input;
    }

    setFontSize(input:string)
    {
        this.fontSize = new SNVAHtmlUnit(input);
    }

    setFontStyle(input:string)
    {
        this.fontStyle = input;
    }

    setFontWeight(input:string)
    {
        this.fontWeight = input;
    }

    toString()
    {
        let result:string = '';
        if(this.fontFamily != '')
        {
            result = result + 'font-family:' + this.fontFamily + ";";
        }

        if(this.fontStyle != '' && this.fontStyle != 'normal')
        {
            result = result + 'font-style:' + this.fontStyle + ";";
        }

        if(this.fontWeight != '' && this.fontWeight != 'normal')
        {
            result = result + 'font-weight:' + this.fontWeight + ";";
        }

        if(this.fontSize.toString() != '')
        {
            result = result + 'font-size:' + this.fontSize.toString() + ';';
        }

        if(this.textAlign != '')
        {
            result = result + 'text-align:' + this.textAlign + ';';
        }

        return  result;
    }
}
