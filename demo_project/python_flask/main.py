from flask import Flask
import controller
from flask_restful import Resource, Api


app = Flask(__name__)
api = Api(app)


api.add_resource(controller.CaiCloudController, '/')

if __name__ == '__main__':
    app.run(debug=True)
