"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Engine = void 0;
var Engine;
(function (Engine_1) {
    var Engine = /** @class */ (function () {
        function Engine() {
            this.engineState = new EngineStateOff();
        }
        Engine.prototype.start = function () {
            this.engineState = this.engineState.start();
        };
        Engine.prototype.stop = function () {
            this.engineState = this.engineState.stop();
        };
        Engine.prototype.failed = function () {
            console.log("Je suis en panne.");
            this.engineState = new EngineStateFailed();
        };
        Engine.prototype.repare = function () {
            if (this.engineState instanceof EngineStateFailed) {
                console.log("Moteur réparé !");
                this.engineState = new EngineStateOff();
            }
            else {
                console.log("Je ne suis pas en panne.");
            }
        };
        return Engine;
    }());
    Engine_1.Engine = Engine;
    var EngineStateOff = /** @class */ (function () {
        function EngineStateOff() {
        }
        EngineStateOff.prototype.start = function () {
            console.log("Je démarre.");
            return new EngineStateOn();
        };
        EngineStateOff.prototype.stop = function () {
            console.log("Déjà arrêté.");
            return this;
        };
        return EngineStateOff;
    }());
    var EngineStateOn = /** @class */ (function () {
        function EngineStateOn() {
        }
        EngineStateOn.prototype.start = function () {
            console.log("Déjà démarré.");
            return this;
        };
        EngineStateOn.prototype.stop = function () {
            console.log("Je m'arrête.");
            return new EngineStateOff();
        };
        return EngineStateOn;
    }());
    var EngineStateFailed = /** @class */ (function () {
        function EngineStateFailed() {
        }
        EngineStateFailed.prototype.start = function () {
            console.log("Je suis en panne. Je ne peux pas démarrer.");
            return this;
        };
        EngineStateFailed.prototype.stop = function () {
            console.log("Je suis en panne. Je ne peux pas m'arrêter");
            return this;
        };
        EngineStateFailed.prototype.repare = function () {
            console.log("Je suis réparé !");
            return new EngineStateOff();
        };
        return EngineStateFailed;
    }());
})(Engine || (exports.Engine = Engine = {}));
var engine = new Engine.Engine();
engine.start();
engine.start();
engine.stop();
engine.stop();
engine.failed();
engine.start();
engine.stop();
engine.repare();
engine.start();
