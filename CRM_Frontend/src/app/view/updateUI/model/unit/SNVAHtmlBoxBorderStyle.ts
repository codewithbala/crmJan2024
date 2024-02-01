export class SNVAHtmlBoxBorderStyle
{
    topStyle    : string = 'none';
    rightStyle  : string = 'none';
    bottomStyle : string = 'none';
    leftStyle   : string = 'none';

    set(name:string, value:string)
    {
        let nameT = name.trim();
        if(nameT == 'border-style')
        {
            let tmp =  value.trim().split(' ').filter((s) => {return s != '';});
            if(tmp.length == 1)
            {
                this.topStyle    = tmp[0];
                this.rightStyle  = tmp[0];
                this.bottomStyle = tmp[0];
                this.leftStyle   = tmp[0];
            }
            else if(tmp.length == 2)
            {
                this.topStyle    = tmp[0];
                this.rightStyle  = tmp[1];
                this.bottomStyle = tmp[0];
                this.leftStyle   = tmp[1];
            }
            else if(tmp.length == 3)
            {
                this.topStyle    = tmp[0];
                this.rightStyle  = tmp[1];
                this.bottomStyle = tmp[2];
                this.leftStyle   = tmp[1];
            }
            else if(tmp.length == 4)
            {
                this.topStyle    = tmp[0];
                this.rightStyle  = tmp[1];
                this.bottomStyle = tmp[2];
                this.leftStyle   = tmp[3];
            }
        }
        else if(nameT == 'border-top-style')
        {
            this.topStyle = value.trim();
        }
        else if(nameT == 'border-right-style')
        {
            this.rightStyle = value.trim();
        }
        else if(nameT == 'border-bottom-style')
        {
            this.bottomStyle = value.trim();
        }
        else if(nameT == 'border-left-style')
        {
            this.leftStyle = value.trim();
        }
    }

    toString()
    {
        if(this.topStyle.toString() != 'none' && this.rightStyle.toString() != 'none' && this.bottomStyle.toString() != 'none' && this.leftStyle.toString() != 'none')
        {
            if(this.topStyle.toString() == this.rightStyle.toString() && this.topStyle.toString() == this.bottomStyle.toString() && this.topStyle.toString() == this.leftStyle.toString())
            {
                return 'border-style:' + this.topStyle.toString() + ';';
            }
            else if(this.topStyle.toString() == this.bottomStyle.toString() && this.leftStyle.toString() == this.rightStyle.toString())
            {
                return 'border-style:' + this.topStyle.toString() + ' ' + this.leftStyle.toString() + ';';
            }
            else if(this.leftStyle.toString() == this.rightStyle.toString())
            {
                return 'border-style:' + this.topStyle.toString() + ' ' + this.leftStyle.toString() + ' ' + this.bottomStyle.toString() +';';
            }
            else
            {
                return 'border-style:' + this.topStyle.toString() + ' ' + this.rightStyle.toString() + ' ' + this.bottomStyle.toString() + ' ' + this.leftStyle.toString() + ';';
            }
        }
        else
        {
            let result = '';
            if(this.topStyle.toString() != 'none')
            {
                result = result + 'border-top-style:' + this.topStyle + ";"
            }
            if(this.rightStyle.toString() != 'none')
            {
                result = result + 'border-right-style:' + this.rightStyle + ";"
            }
            if(this.bottomStyle.toString() != 'none')
            {
                result = result + 'border-bottom-style:' + this.bottomStyle + ";"
            }
            if(this.leftStyle.toString() != 'none')
            {
                result = result + 'border-left-style:' + this.leftStyle + ";"
            }
            return result;
        }
    }
}
