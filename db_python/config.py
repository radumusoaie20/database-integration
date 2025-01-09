# You need to install jproperties for this to work! Use this command : pip install jproperties
from typing import override

from jproperties import Properties

configs = Properties()

with open('config.properties', 'rb') as config_file:
    configs.load(config_file)

def get_property(name):
    return configs.get(name).data