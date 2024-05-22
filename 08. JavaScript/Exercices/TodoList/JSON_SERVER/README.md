# JSON-Server

## Installation

1. Install JSON-Server

```bash
npm i json-server
```

2. Create a file named db.json

```json
{
  "tasks": [
    {
      "id": "1",
      "name": "Apprendre Duelists Of Eden",
      "done": false
    },
    {
      "id": "2",
      "name": "Jouer Ã  RoR2",
      "done": true
    },
    {
      "id": "3",
      "name": "Terminer le deck Chat de mon jeu de carte",
      "done": false
    }
  ]
}
```

## Start the server

1. Start server

```bash
npx json-server ./db.json
```

## Source

[source](https://www.npmjs.com/package/json-server)