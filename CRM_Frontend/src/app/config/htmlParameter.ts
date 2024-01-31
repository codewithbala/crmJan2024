import {Injectable} from "@angular/core";
import * as configure  from '../../assets/htmlParameter.json';

@Injectable({
    providedIn: 'root'
})
export class HtmlParameter
{
    public htmlParameter:any = configure;
    public htmlUnit:string[] = [];

    public htmlBorderStyle :string[] = [];
    public htmlShadowStyle :string[] = [];
    public htmlSizeStyle   :string[] = [];

    public htmlTextFont    :string[] = [];
    public htmlTextStyle   :string[] = [];
    public htmlTextWeight  :string[] = [];
    public htmlTextAlign   :string[] = [];

    constructor()
    {
        this.htmlUnit = this.htmlParameter.HTML_UNIT;
        this.htmlBorderStyle = this.htmlParameter.HTML_BORDER_STYLE;
        this.htmlShadowStyle = this.htmlParameter.HTML_SHADOW_TYPE;
        this.htmlSizeStyle   = this.htmlParameter.HTML_SIZE_TYPE;

        this.htmlTextFont    = this.htmlParameter.HTML_TEXT_Font;
        this.htmlTextStyle   = this.htmlParameter.HTML_TEXT_STYLE;
        this.htmlTextWeight  = this.htmlParameter.HTML_TEXT_WEIGHT;
        this.htmlTextAlign   = this.htmlParameter.HTML_TEXT_ALIGN;

    }

}
