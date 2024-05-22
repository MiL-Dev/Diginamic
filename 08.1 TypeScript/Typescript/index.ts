export namespace Engine {
  interface EngineState {
    start(): EngineState;
    stop(): EngineState;
  }

  export class Engine {
    private engineState: EngineState;

    constructor() {
      this.engineState = new EngineStateOff();
    }

    start() {
      this.engineState = this.engineState.start();
    }

    stop() {
      this.engineState = this.engineState.stop();
    }

    failed() {
      console.log("Je suis en panne.");
      this.engineState = new EngineStateFailed();
    }

    repare() {
      if (this.engineState instanceof EngineStateFailed) {
        console.log("Moteur réparé !");
        this.engineState = new EngineStateOff();
      } else {
        console.log("Je ne suis pas en panne.");
      }
    }
  }

  class EngineStateOff implements EngineState {
    start() {
      console.log("Je démarre.");
      return new EngineStateOn();
    }

    stop() {
      console.log("Déjà arrêté.");
      return this;
    }
  }

  class EngineStateOn implements EngineState {
    start() {
      console.log("Déjà démarré.");
      return this;
    }

    stop() {
      console.log("Je m'arrête.");
      return new EngineStateOff();
    }
  }

  class EngineStateFailed implements EngineState {
    start() {
      console.log("Je suis en panne. Je ne peux pas démarrer.");
      return this;
    }

    stop() {
      console.log("Je suis en panne. Je ne peux pas m'arrêter");
      return this;
    }

    repare() {
      console.log("Je suis réparé !");
      return new EngineStateOff();
    }
  }
}

const engine = new Engine.Engine();
engine.start();
engine.start();
engine.stop();
engine.stop();
engine.failed();
engine.start();
engine.stop();
engine.repare();
engine.start();
