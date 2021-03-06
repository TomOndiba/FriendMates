/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 *  Bootstrap Dropdown Hover - v4.1.1
 *  Open dropdown menus on mouse hover, the proper way.
 *  http://www.virtuosoft.eu/code/bootstrap-dropdown-hover/
 *
 *  Made by István Ujj-Mészáros
 *  Under Apache License v2.0 License
 */

!function(o){"function"==typeof define&&define.amd?define(["jquery"],o):"object"==typeof module&&module.exports?module.exports=function(e,t){return void 0===t&&(t="undefined"!=typeof window?require("jquery"):require("jquery")(e)),o(t),t}:o(jQuery)}(function(i){var o,r="bootstrapDropdownHover",n={clickBehavior:"sticky",hideTimeout:200},d=!1,s=!1,a=!1;function u(e,t){this.element=i(e),this.settings=i.extend({},n,t,this.element.data()),this._defaults=n,this._name=r,this.init()}u.prototype={init:function(){var t,e;return this.setClickBehavior(this.settings.clickBehavior),this.setHideTimeout(this.settings.hideTimeout),t=this,(e=i("body")).one("touchstart.dropdownhover",function(){s=!0}),e.one("mousemove.dropdownhover",function(){s||(a=!0)}),i(".dropdown-toggle, .dropdown-menu",t.element.parent()).on("mouseenter.dropdownhover",function(){a&&!i(this.hover)&&(a=!1),a&&(clearTimeout(o),t.element.parent().is(".open, .show")||(d=!1,t.element.dropdown("toggle")))}),i(".dropdown-toggle, .dropdown-menu",t.element.parent()).on("mouseleave.dropdownhover",function(){a&&(d||(o=setTimeout(function(){t.element.parent().is(".open, .show")&&t.element.dropdown("toggle")},t.settings.hideTimeout)))}),t.element.on("click.dropdownhover",function(e){if("link"===t.settings.clickBehavior||a)switch(t.settings.clickBehavior){case"default":return;case"disable":return e.preventDefault(),void e.stopImmediatePropagation();case"link":return void e.stopImmediatePropagation();case"sticky":return void(d?d=!1:(d=!0,t.element.parent().is(".open, .show")&&(e.stopImmediatePropagation(),e.preventDefault())))}}),this.element},setClickBehavior:function(e){return this.settings.clickBehavior=e,this.element},setHideTimeout:function(e){return this.settings.hideTimeout=e,this.element},destroy:function(){var e;return clearTimeout(o),i(".dropdown-toggle, .dropdown-menu",(e=this).element.parent()).off(".dropdownhover"),i(".dropdown-toggle, .dropdown-menu",e.element.parent()).off(".dropdown"),e.element.off(".dropdownhover"),i("body").off(".dropdownhover"),this.element.data("plugin_"+r,null),this.element}},i.fn[r]=function(o){var t,n=arguments;return void 0===o||"object"==typeof o?(i.contains(document,i(this)[0])||i('[data-toggle="dropdown"]').each(function(e,t){i(t).bootstrapDropdownHover(o)}),this.each(function(){i(this).hasClass("dropdown-toggle")&&"dropdown"===i(this).data("toggle")?i.data(this,"plugin_"+r)||i.data(this,"plugin_"+r,new u(this,o)):i('[data-toggle="dropdown"]',this).each(function(e,t){i(t).bootstrapDropdownHover(o)})})):"string"==typeof o&&"_"!==o[0]&&"init"!==o?(this.each(function(){var e=i.data(this,"plugin_"+r);e instanceof u&&"function"==typeof e[o]&&(t=e[o].apply(e,Array.prototype.slice.call(n,1)))}),void 0!==t?t:this):void 0}});