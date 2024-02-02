export class SNVAHtmlColor
{
    public rChannel:number = 0;
    public gChannel:number = 0;
    public bChannel:number = 0;
    public aChannel:number = 0;
    public colorString:string = '';

    constructor(input:string)
    {
        if(input == undefined || input == null || input == '')
        {
            this.rChannel = 0;
            this.gChannel = 0;
            this.bChannel = 0;
            this.aChannel = 0;
        }
        else
        {
            if(input.includes('rgba'))
            {
                let tmp = input.replaceAll(" ", '').substring(5, input.length).split(',')
                this.rChannel = parseInt(tmp[0]);
                this.gChannel = parseInt(tmp[1]);
                this.bChannel = parseInt(tmp[2]);
                this.aChannel = parseFloat(tmp[3]);
            }
            else if(input.includes('rgb'))
            {
                let tmp = input.replaceAll(" ", '').substring(5, input.length).split(',')
                this.rChannel = parseInt(tmp[0]);
                this.gChannel = parseInt(tmp[1]);
                this.bChannel = parseInt(tmp[2]);
                this.aChannel = 100;
            }
            else if(input.includes('#'))
            {
                this.rChannel = parseInt(input.slice(-6, -4), 16);
                this.gChannel = parseInt(input.slice(-4, -2), 16);
                this.bChannel = parseInt(input.slice(-2), 16);
                this.aChannel = 1;
            }
            else
            {
                this.colorString = input;
            }
        }
    }

    getColorValue():string
    {
        if(this.colorString == '')
        {
            let R = this.rChannel.toString(16);
            let G = this.gChannel.toString(16);
            let B = this.bChannel.toString(16);
            if(R.length == 1)
            {
                R = '0' + R;
            }
            if(G.length == 1)
            {
                G = '0' + G;
            }
            if(B.length == 1)
            {
                B = '0' + B;
            }
            return '#' + R + G + B;
        }
        return this.colorString;
    }

    setColorValue(input:string):void
    {
        this.rChannel = parseInt(input.slice(-6, -4), 16);
        this.gChannel = parseInt(input.slice(-4, -2), 16);
        this.bChannel = parseInt(input.slice(-2), 16);
    }

    setTransparency(input:any):void
    {
        console.log('[SNVAHtmlColor]:'+input);
        this.aChannel = parseFloat(input) / 100;
    }

    toString()
    {
        if(this.aChannel == 0)
        {
            return '';
        }

        if(this.colorString != '')
        {
            return this.colorString;
        }
        else
        {
            if(this.aChannel == 1)
            {
                let R = this.rChannel.toString(16);
                let G = this.gChannel.toString(16);
                let B = this.bChannel.toString(16);
                if(R.length == 1)
                {
                    R = '0' + R;
                }
                if(G.length == 1)
                {
                    G = '0' + G;
                }
                if(B.length == 1)
                {
                    B = '0' + B;
                }
                return '#' + R + G + B;
            }
            return 'rgba(' + this.rChannel + ',' + this.gChannel + ',' + this.bChannel + ',' + this.aChannel + ')';
        }
    }
}
