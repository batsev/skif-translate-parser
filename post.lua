wrk.method = "POST"
wrk.headers["Content-Type"] = "application/json"
wrk.body = [[
{"payload": {
		"task_id": -5974025799988702997,
		"flow": "monitoring",
		"method": "monitoring"
	},
	"skif_auth": {
		"user": {
			"id": "9f4e5ea6-da0b-458a-ab84-9929a32bc9ac",
			"name": "Mih",
			"lang": {
				"key": "ru",
				"type": "languages",
				"value": "Русский"
			}
		},
		"company": {
			"id": "adb2b4c5-b672-43d1-b66f-da0ac318f844",
			"name": "THE BOYS",
			"timezone": {
				"key": "UTC+6",
				"type": "timezones",
				"value": {
					"underlyingString": "translate.timezones.key.UTCplus6"
				}
			}
		}
	},
	"skif_units": {
		"id": "d28d566e-ece6-4481-92b4-e47801d8dccc",
		"company_id": "adb2b4c5-b672-43d1-b66f-da0ac318f844",
		"name": "1",
		"type": {
			"key": "route_transport",
			"type": "unit_type",
			"value": "translate.route_transport"
		},
		"terminal_type": {
			"key": "mtstracker",
			"type": "terminal_type",
			"value": "Mtstracker"
		},
		"imei": "1",
		"phonenumber": "",
		"icon": {
			"key": "van-vw_red",
			"type": "unit_icon",
			"value": "Иконка"
		},
		"services": [],
		"sensors": [],
		"custom_fields": [{
			"name": "Мин. объем заправки",
			"key": "fuel_fillings_minfilling",
			"value": "10",
			"group": "cf_fuel"
		}, {
			"name": "Игнор-ть сообщ-я после начала движения",
			"key": "fuel_fillings_msgignorestart",
			"value": "60",
			"group": "cf_fuel"
		}, {
			"name": "Мин. время остановки для опр-ия слива",
			"key": "fuel_fillings_minstaytheft",
			"value": "60",
			"group": "cf_fuel"
		}, {
			"name": "Мин. объем слива",
			"key": "fuel_fillings_minitheft",
			"value": "10",
			"group": "cf_fuel"
		}, {
			"name": "Мин. время стоянки",
			"key": "tripdetector_minparktime",
			"value": "300",
			"group": "cf_trips"
		}, {
			"name": "Коэф. пробега",
			"key": "advanced_mileagecoeff",
			"value": "1",
			"group": "cf_trips"
		}, {
			"name": "Мин. скорость движ-я",
			"key": "tripdetector_minmovespeed",
			"value": "3",
			"group": "cf_trips"
		}, {
			"name": "Мин. расст-ие поездки",
			"key": "tripdetector_mintripdist",
			"value": "100",
			"group": "cf_trips"
		}, {
			"name": "Макс. интервал между сообщ-ми (сек)",
			"key": "advanced_maxintervalmsg",
			"value": "3600",
			"group": "cf_trips"
		}, {
			"name": "Макс. расст-ие между сообщ-ми (м)",
			"key": "tripdetector_maxdistancemsg",
			"value": "1000",
			"group": "cf_trips"
		}, {
			"name": "Мин. время поездки",
			"key": "tripdetector_mintriptime",
			"value": "60",
			"group": "cf_trips"
		}, {
			"name": "Опр-ие движ-я",
			"key": "key_tripdetector_movedetect",
			"value": "speedkph",
			"group": "cf_trips"
		}, {
			"name": "Определение пробега",
			"key": "tripdetector_mileagedetect",
			"value": "GPS",
			"group": "cf_trips"
		}, {
			"name": "Определение моточасов",
			"key": "key_motohourdetector",
			"value": "ignition",
			"group": "cf_motohours"
		}, {
			"name": "Аналитик",
			"key": "analyst",
			"value": "",
			"group": "cf_etc"
		}, {
			"name": "Установка",
			"key": "installer",
			"value": "",
			"group": "cf_etc"
		}, {
			"name": "Дата установки",
			"key": "install_date",
			"value": "",
			"group": "cf_etc"
		}, {
			"name": "Серийный номер",
			"key": "serial_number",
			"value": "",
			"group": "cf_etc"
		}, {
			"name": "Серийный номер ДУТ",
			"key": "serial_number_dut",
			"value": "",
			"group": "cf_etc"
		}, {
			"name": "Серийный номер пломбы ДУТ",
			"key": "dut_seal_serial_number",
			"value": "",
			"group": "cf_etc"
		}, {
			"name": "Гос номер",
			"key": "license_plate_number",
			"value": "",
			"group": "cf_etc"
		}],
		"_delete": true
	}
}
]]
