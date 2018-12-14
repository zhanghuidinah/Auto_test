#! coding=utf8
from flask_restful import Resource, Api
from flask import make_response
import json


class CaiCloudController(Resource):
    def get(self):
        text = {
            "name": u"才云科技",
            "telphone": "400-1014-588",
            "address": u"杭州市滨江区六和路368号海创基地北楼B3082"
        }
        response = make_response(json.dumps(text, ensure_ascii=False))
        return response

