Weather API
============

Weather is a simple tool for getting the current weather. It returns the temperature, humidity, and more for a given location.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Javascript Wrapper for the [Weather API](https://apiverve.com/marketplace/api/weatherforecast)

---

## Installation
	npm install @apiverve/weatherforecast --save

---

## Configuration

Before using the weatherforecast API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Weather API documentation is found here: [https://docs.apiverve.com/api/weatherforecast](https://docs.apiverve.com/api/weatherforecast).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
var weatherforecastAPI = require('@apiverve/weatherforecast');
var api = new weatherforecastAPI({
    api_key: [YOUR_API_KEY],
    secure: true //(Optional, defaults to true)
});
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
var query = {
  city: "San Francisco"
};
```

###### Simple Request (using Callback)

```
api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "location": {
      "name": "San Francisco",
      "region": "California",
      "country": "United States of America",
      "lat": 37.78,
      "lon": -122.42,
      "tz_id": "America/Los_Angeles",
      "localtime_epoch": 1715571274,
      "localtime": "2024-05-12 20:34"
    },
    "current": {
      "tempC": 13.3,
      "tempF": 55.9,
      "windMph": 13.6,
      "windKph": 22,
      "windDegree": 280,
      "windDir": "W",
      "pressureMb": 1014,
      "pressureIn": 29.93,
      "precipMm": 0,
      "precipIn": 0,
      "feelslikeC": 11.9,
      "feelslikeF": 53.4,
      "visKm": 14,
      "visMiles": 8,
      "gustMph": 14.3,
      "gustKph": 23
    },
    "forecast": {
      "forecastday": [
        {
          "date": "2024-05-12",
          "date_epoch": 1715472000,
          "day": {
            "maxtemp_c": 15.7,
            "maxtemp_f": 60.2,
            "mintemp_c": 11.7,
            "mintemp_f": 53,
            "avgtemp_c": 13.3,
            "avgtemp_f": 55.9,
            "maxwind_mph": 13,
            "maxwind_kph": 20.9,
            "totalprecip_mm": 0.12,
            "totalprecip_in": 0,
            "totalsnow_cm": 0,
            "avgvis_km": 10,
            "avgvis_miles": 6,
            "avghumidity": 82,
            "daily_will_it_rain": 1,
            "daily_chance_of_rain": 83,
            "daily_will_it_snow": 0,
            "daily_chance_of_snow": 0,
            "condition": {
              "text": "Patchy rain nearby",
              "code": 1063
            },
            "uv": 9
          }
        },
        {
          "date": "2024-05-13",
          "date_epoch": 1715558400,
          "day": {
            "maxtemp_c": 15.3,
            "maxtemp_f": 59.5,
            "mintemp_c": 11,
            "mintemp_f": 51.8,
            "avgtemp_c": 12.8,
            "avgtemp_f": 55,
            "maxwind_mph": 12.8,
            "maxwind_kph": 20.5,
            "totalprecip_mm": 0.06,
            "totalprecip_in": 0,
            "totalsnow_cm": 0,
            "avgvis_km": 10,
            "avgvis_miles": 6,
            "avghumidity": 81,
            "daily_will_it_rain": 0,
            "daily_chance_of_rain": 0,
            "daily_will_it_snow": 0,
            "daily_chance_of_snow": 0,
            "condition": {
              "text": "Partly Cloudy ",
              "code": 1003
            },
            "uv": 8
          }
        },
        {
          "date": "2024-05-14",
          "date_epoch": 1715644800,
          "day": {
            "maxtemp_c": 16.7,
            "maxtemp_f": 62.1,
            "mintemp_c": 10.5,
            "mintemp_f": 50.8,
            "avgtemp_c": 13.2,
            "avgtemp_f": 55.8,
            "maxwind_mph": 12.8,
            "maxwind_kph": 20.5,
            "totalprecip_mm": 0.02,
            "totalprecip_in": 0,
            "totalsnow_cm": 0,
            "avgvis_km": 10,
            "avgvis_miles": 6,
            "avghumidity": 77,
            "daily_will_it_rain": 0,
            "daily_chance_of_rain": 0,
            "daily_will_it_snow": 0,
            "daily_chance_of_snow": 0,
            "condition": {
              "text": "Sunny",
              "code": 1000
            },
            "uv": 8
          }
        }
      ]
    }
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2024 APIVerve, and Evlar LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.