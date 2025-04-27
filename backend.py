from flask import Flask, request, jsonify
from flask_cors import CORS
from time import sleep


valid_users = [
    {
        "uuid": hash("user1"),
        "name": "John Doe",
        "age": 30,
        "username": "user1",
        "email": "helloworldabc@gmail.com",
        "password": "helloworld",
        "address": "123 Main St",
        "experience": 5,
    },
    {
        "uuid": hash("user2"),
        "name": "Jane Mustang",
        "age": 36,
        "username": "user2",
        "email": "jmustang123@calpoly.edu",
        "password": "password123",
        "address": "456 Elm St",
        "experience": 2,
    },
]

# public Cow(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate, String cowType, Color color, float weight, int milkProductionRate, int milkCapacity) {
#     super(id, position, width, height, health, hunger, happiness, age, reproductionRate);
#     this.cowType = cowType;
#     this.color = color;
#     this.weight = weight;
#     this.milkProductionRate = milkProductionRate;
#     this.milkCapacity = milkCapacity;
# }
board = {
    "user1": [
        {
            "type": "Cow",
            "id": 1,
            "position": (0, 0),
            "width": 20,
            "height": 20,
            "health": 100,
            "hunger": 5,
            "happiness": 5,
            "age": 1,
            "reproductionRate": 1,
            "cowType": "Jersey",
            "color": (255, 255, 255),
            "weight": 100.0,
            "milkProductionRate": 10,
            "milkCapacity": 100,
        },
        {
            "type": "Cow",
            "id": 9,
            "position": (120, 60),
            "width": 20,
            "height": 20,
            "health": 100,
            "hunger": 5,
            "happiness": 3,
            "age": 1,
            "reproductionRate": 2,
            "cowType": "Holstein",
            "color": (255, 255, 255),
            "weight": 60.0,
            "milkProductionRate": 10,
            "milkCapacity": 100,
        },
        {
            "type": "Carrot",
            "id": 6,
            "position": (1200, 60),
            "width": 20,
            "height": 20,
            "type": "Carrot",
            "health": 100,
            "growthRate": 5,
            "sunlightLevel": 5,
            "nutrientLevel": 5,
            "harvestTime": 10,
            "waterLevel": 0,
            "age": 0,
        },
        {
            "type": "Pig",
            "id": 24,
            "position": (300, 400),
            "width": 20,
            "height": 20,
            "health": 50,
            "hunger": 5,
            "happiness": 5,
            "age": 3,
            "reproductionRate": 10,
            "color": (255, 255, 255),
            "weight": 100.0,
            "baconProductionRate": 10,
            "baconWeight": 25,
        },
        {
            "type": "Corn",
            "id": 77,
            "position": (430, 60),
            "width": 20,
            "height": 20,
            "type": "Corn",
            "health": 30,
            "growthRate": 5,
            "sunlightLevel": 5,
            "nutrientLevel": 5,
            "harvestTime": 10,
            "waterLevel": 5,
            "age": 0,
        },
    ]
}

CDFA_LIST = [
    "CloverLeaf Animal Welfare Systems",
    "Animal Welfare Approved",
    "Certified Humane",
    "Global Animal Partnership",
    "American Humane Certified",
    "USDA Organic",
]

BUSINESS_INCOME = {
    12345: 10000,
    67890: 20000,
    54321: 15000,
    98765: 25000,
    13579: 30000,
    24680: 12000,
    11223: 18000,
}

app = Flask(__name__)
CORS(app)


@app.route("/getUser", methods=["GET"])
def login():
    username = request.args.get("username")
    password = request.args.get("password")
    sleep(1)  # Simulate a delay for the request
    if username is None or password is None or username == "" or password == "":
        return jsonify({"message": "Username and password are required!"}), 400
    for user in valid_users:
        if user["username"] == username and user["password"] == password:
            return jsonify(
                {
                    "uuid": user["uuid"],
                    "name": user["name"],
                    "age": user["age"],
                    "username": user["username"],
                    "email": user["email"],
                    "address": user["address"],
                    "experience": user["experience"],
                }
            )
    return jsonify({"message": "Invalid username or password!"}), 401


@app.route("/get_board_data/<string:username>", methods=["GET"])
def get_board_data(username):
    sleep(1)  # Simulate a delay for the request
    return jsonify(
        {
            "id": username,
            "board": board.get(username, []),
        }
    )


@app.route("/get_income/<int:taxId>", methods=["GET"])
def get_income(taxId):
    sleep(1)
    return (str(BUSINESS_INCOME.get(taxId, 0)), 200)


@app.route("/get_cdfa_data", methods=["GET"])
def get_cdfa_data():
    sleep(1)
    return (
        CDFA_LIST,
        200,
    )


if __name__ == "__main__":
    app.run(debug=True)
