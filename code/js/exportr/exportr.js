/*global define, require, exports*/
/*
 *  exportr v 0.1
 *
 *  inspired by code from FunctionSack: https://github.com/ddrcode/FunctionSack
 *
 *  Copyright (C) 2011 Mariano Guerra
 *
 *  Licensed under the MIT license.
 *  http://www.opensource.org/licenses/mit-license.php
 */


(function(__global){
    "use strict";

    var __utils = {

        mixin: function(dst,src1) {
            var src, prop, srcId, len;
            for(srcId=1, len=arguments.length; srcId < len; ++srcId) {
                for(prop in (src=arguments[srcId])) {
                    if (src.hasOwnProperty(prop)){
                        dst[prop] = src[prop];
                    }
                }
            }
            return dst;
        },

        isString: function(obj) {
            return Object.prototype.toString.call(obj) === "[object String]";
        },

        isFunction: function(obj) {
            return Object.prototype.toString.call(obj) === "[object Function]";
        }
    };

    var $NS = {
        // Provide the library via environment-dependent method
        define: function (module, moduleId, defaultNamespace){
            var libConfig = (__global) ? __global["__FUNCTION_" + moduleId + "_CONFIG__"] : undefined;

            if (typeof define === "function" && typeof require === "function" && typeof require.onScriptLoad === "function") {
                // RequireJS
                define(module);
            } else if (typeof require === "function" && typeof exports === "object") {
                // CommonJS
                __utils.mixin(exports, module);
            } else if (typeof libConfig === "object" && (__global || libConfig.context)) {
                // browser script tag, Rhino, SpiderMonkey, etc (with dedicated config object)
                (function(config){
                    var ctx = config.context || __global;
                    if (__utils.isFunction(ctx)) {
                        ctx(module);
                        return;
                    }
                    if (!!config.ignoreRootNamespace) {
                        __utils.mixin(ctx, module);
                        return;
                    }
                    ctx[ __utils.isString(config.rootNamespaceName) ? config.rootNamespaceName : defaultNamespace ] = module;
                }(libConfig));
            } else if (__global) {
                // browser script tag, Rhino, SpiderMonkey, etc
                __global[defaultNamespace] = module;
            } else {
                // shouldn't take place unless someone plays with the code or with the context
                throw new Error("Unspecified " + defaultNamespace + " export method");
            }
        },
        require: function (modules, onLoadOk) {
            var imported = [], i;
            if (typeof define === "function" && typeof require === "function" && typeof require.onScriptLoad === "function") {
                // RequireJS
                require(modules, onLoadOk);
            } else if (typeof require === "function" && typeof exports === "object") {
                // CommonJS
                for(i = 0; i < modules.length; i += 1) {
                    imported.push(require(modules[i]));
                }

                onLoadOk.apply(null, imported);
            } else {
                // shouldn't take place unless someone plays with the code or with the context
                throw new Error("Unspecified " + defaultNamespace + " import method");
            }
        }
    };

    // export exportr :D
    $NS.exportr($NS, "EXPORTR", "exportr");

}(this));
