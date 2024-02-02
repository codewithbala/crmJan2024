import {Injectable} from "@angular/core";
import * as configure  from '../../assets/configure.json';
import {UiModel} from "../view/updateUI/model/uiModel";

@Injectable({
    providedIn: 'root'
})
export class UIconfigure
{
    public myConfigure:any = configure;
    public header:UiModel[] = [];
    public footer:UiModel[] = []

    constructor()
    {
        this.header = this.myConfigure.header;
        this.footer = this.myConfigure.footer;
    }

    public BACKGROUND =
        {
            particles:true, // set false to close particles.
            css:'',
            style:''
        };

    public ACCOUNT_DETAIL =
        {
            css:'container mt-4 mb-4 pt-4',
            style:'min-height: 800px;',
            MENU_BAR:
                {
                    css:'col-sm-3 p-2',
                    style:'',
                    CARD:
                        {
                            css:'card border border-success cardBackGround',
                            style:'height: 600px;',
                            BODY:
                                {
                                    css:'card-body text-center',
                                    style:'',
                                    NAME:
                                        {
                                            css:'h5 text_font text-white',
                                            style:''
                                        },
                                    LIST:
                                        {
                                            css:'col-sm-12 border-bottom text_hover',
                                            css_readOnly:'col-sm-12 border-bottom',
                                            style:'',
                                            LABEL:
                                                {
                                                    css:'h5 text_font text-white',
                                                    style:'',
                                                }
                                        }
                                }
                        }
                },
            WORKSPACE:
                {
                    css:'col-sm-9 p-2',
                    style:'',
                    CARD:
                        {
                            css:'card border border-success cardBackGround',
                            style:'height: 600px;',
                            BODY:
                                {
                                    css:'card-body text-center',
                                    style:'',
                                    ERROR:
                                        {
                                            css:'h1 text-danger text_font',
                                            style:''
                                        },
                                    CONTAINER:
                                        {
                                            css:'card-body',
                                            style:'',
                                            TITLE:
                                                {
                                                    css:'h3 card-title text-center border-bottom pb-4 text-white text_font',
                                                    style:''
                                                },
                                            BODY:
                                                {
                                                    css:'',
                                                    style:'min-height: 260px',
                                                    INFO:
                                                        {
                                                            ROW:
                                                                {
                                                                    css:'row m-4 mt-4',
                                                                    style:'',
                                                                    ICON:
                                                                        {
                                                                            css:'col-3 pe-4 justify-content-end',
                                                                            style:'',
                                                                            IMG:
                                                                                {
                                                                                    css:'img_lg img_radius',
                                                                                    style:''
                                                                                },
                                                                            INPUT:
                                                                                {
                                                                                    css:'mt-3',
                                                                                    style:''
                                                                                }
                                                                        },
                                                                    DATA:
                                                                        {
                                                                            css:'col-8 text-start mt-4',
                                                                            style:'',
                                                                            LABEL:
                                                                                {
                                                                                    css:'col-3',
                                                                                    style:'',
                                                                                    TEXT:
                                                                                        {
                                                                                            css:'text_font text-white',
                                                                                            style:''
                                                                                        }
                                                                                },
                                                                            VALUE:
                                                                                {
                                                                                    css:'col-8',
                                                                                    style:'',
                                                                                    TEXT:
                                                                                        {
                                                                                            css:'text_font text-white',
                                                                                            style:''
                                                                                        }
                                                                                }
                                                                        }
                                                                },
                                                        },
                                                    ADDRESS: // TODO need to re-Design.
                                                        {
                                                            LINE1:
                                                                {
                                                                    ROW:
                                                                        {
                                                                            css:'row m-3 mt-5',
                                                                            style:'',
                                                                        },
                                                                    LABEL:
                                                                        {
                                                                            css:'col-3 text-end',
                                                                            style:'',
                                                                            TEXT:
                                                                                {
                                                                                    css:'text_font text-white',
                                                                                    style:'',
                                                                                }
                                                                        },
                                                                    VALUE:
                                                                        {
                                                                            css:'col-7 text-start',
                                                                            style:'',
                                                                            INPUT:
                                                                                {
                                                                                    css:"form-control text_font",
                                                                                    style:'',
                                                                                }
                                                                        }

                                                                },
                                                            LINE2:
                                                                {
                                                                    ROW:
                                                                        {
                                                                            css:'row m-3',
                                                                            style:'',
                                                                        },
                                                                    LABEL:
                                                                        {
                                                                            css:'col-3 text-end',
                                                                            style:'',
                                                                            TEXT:
                                                                                {
                                                                                    css:'text_font text-white',
                                                                                    style:'',
                                                                                }
                                                                        },
                                                                    VALUE:
                                                                        {
                                                                            css:'col-6 text-start',
                                                                            style:'',
                                                                            INPUT:
                                                                                {
                                                                                    css:"form-control text_font",
                                                                                    style:'',
                                                                                }
                                                                        }
                                                                },
                                                            COUNTRY:{},
                                                            STATE:{},
                                                            CITY:{},
                                                            ZIP:{},
                                                        },
                                                    PHONE:
                                                        {
                                                            ROW:
                                                                {
                                                                    css:'row m-3 mt-5',
                                                                    style:'',
                                                                    LABEL:
                                                                        {
                                                                            css:'col-4 text-end',
                                                                            style:'',
                                                                            TEXT:
                                                                                {
                                                                                    css:'text_font text-white',
                                                                                    style:'',
                                                                                }
                                                                        },
                                                                    VALUE:
                                                                        {
                                                                            css:'col-4 text-start',
                                                                            style:'',
                                                                            TEXT:
                                                                                {
                                                                                    css:'text_font text-white',
                                                                                    style:'',
                                                                                },
                                                                            INPUT:
                                                                                {
                                                                                    css:"form-control text_font",
                                                                                    style:'',
                                                                                }
                                                                        }
                                                                }
                                                        },
                                                    PASSWORD:
                                                        {
                                                            ROW:
                                                                {
                                                                    css1:'row m-3 mt-5',
                                                                    style1:'',
                                                                    css2: 'row m-3',
                                                                    style2:'',
                                                                    LABEL:
                                                                        {
                                                                            css:'col-3 text-end',
                                                                            style:'',
                                                                            TEXT:
                                                                                {
                                                                                    css:'text_font text-white',
                                                                                    style:'',
                                                                                }
                                                                        },
                                                                    VALUE:
                                                                        {
                                                                            css:'col-7 text-start',
                                                                            style:'',
                                                                            INPUT:
                                                                                {
                                                                                    css:"form-control text_font",
                                                                                    style:'',
                                                                                }
                                                                        }
                                                                }
                                                        },
                                                },
                                            BUTTON:
                                                {
                                                    css:'col-sm-12 text-end mt-4 pt-2',
                                                    style:'',
                                                    BUTTON:
                                                        {
                                                            css:'btn btn-primary mb-3 btn-lg py-1 px-5 ms-4',
                                                            style:'',
                                                        }
                                                }
                                        },
                                }
                        }
                }
        };

}
