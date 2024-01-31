export class SNVAHtmlUnit
{
    public size:string = '';
    public unit:string = '';

    constructor(input:string)
    {
        if(input != '')
        {
            this.unit = input.replace(/[.0-9]/g, '').replace('-','');
            this.size = input.replaceAll(this.unit,'');
        }
    }

    toString()
    {
        if(this.size != '')
        {
            return this.size + this.unit;
        }
        return '';
    }

    equal(input:SNVAHtmlUnit)
    {
        if(this.size == input.size && this.unit == input.unit)
        {
            return true;
        }
        return false;
    }


}
