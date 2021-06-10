from flask import Flask
from flask import json
import logging

app = Flask(__name__)


@app.route("/")
def hello():
    app.logger.info("Main requested!")
    return "Hello Bhupend!"


@app.route("/status")
def status():
    response = app.response_class(
        response=json.dumps({"result": "OK - healthy"}),
        status=200,
        mimetype="application/json"
    )
    app.logger.info("Status requested!")
    return response


@app.route("/metrics")
def metrics():
    response = app.response_class(
        response=json.dumps(
            {"status": "success", "code": 0, "data": {"UserCount": 140, "UserCountActive": 23}}),
        status=200,
        mimetype="application/json"
    )
    app.logger.info("Metrics requested!")
    return response


if __name__ == "__main__":
    logging.basicConfig(level=logging.DEBUG,
                        force=True,
                        handlers=[logging.FileHandler("app.log"), logging.StreamHandler()])
    app.run(host='0.0.0.0')
