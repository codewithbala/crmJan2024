import {SNVAHtmlUnit} from "./SNVAHtmlUnit";

export class SNVAHtmlBoxSize
{
    boxWidth  :SNVAHtmlUnit = new SNVAHtmlUnit('');
    boxHeight :SNVAHtmlUnit = new SNVAHtmlUnit('');
    boxWidthStyle  : string = '';
    boxHeightStyle : string = '';

    constructor() {
    }

    set(name:string, value:string)
    {
        if(name.trim() == 'width')
        {
            this.boxWidthStyle = '';
            this.boxWidth = new SNVAHtmlUnit(value);
        }
        if(name.trim() == 'min-width')
        {
            this.boxWidthStyle = 'min';
            this.boxWidth = new SNVAHtmlUnit(value);
        }
        if(name.trim() == 'max-width')
        {
            this.boxWidthStyle = 'max';
            this.boxWidth = new SNVAHtmlUnit(value);
        }
        if(name.trim() == 'height')
        {
            this.boxHeightStyle = '';
            this.boxHeight = new SNVAHtmlUnit(value);
        }
        if(name.trim() == 'min-height')
        {
            this.boxHeightStyle = 'min';
            this.boxHeight = new SNVAHtmlUnit(value);
        }
        if(name.trim() == 'max-height')
        {
            this.boxHeightStyle = 'max';
            this.boxHeight = new SNVAHtmlUnit(value);
        }
    }

    toString()
    {
        let result = ''
        if(this.boxWidth.toString() != '')
        {
            if(this.boxWidthStyle != '')
            {
                result = result + this.boxWidthStyle + '-width:' + this.boxWidth.toString() + ';';
            }
            else
            {
                result = result + 'width:' + this.boxWidth.toString() + ';';
            }
        }

        if(this.boxHeight.toString() != '')
        {
            if(this.boxHeightStyle != '')
            {
                result = result + this.boxHeightStyle + '-height:' + this.boxHeight.toString() + ';';
            }
            else
            {
                result = result + 'height:' + this.boxHeight.toString() + ';';
            }
        }
        return result;
    }
}
