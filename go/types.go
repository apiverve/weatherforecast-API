package weatherforecast

import (
	"fmt"
	"reflect"
	"strings"
)

// Request contains the parameters for the Weather API.
type Request struct {
	City string `json:"city"` // Required
}

// ToQueryParams converts the request struct to a map of query parameters.
// Only non-zero values are included.
func (r *Request) ToQueryParams() map[string]string {
	params := make(map[string]string)
	if r == nil {
		return params
	}

	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		// Get the json tag for the field name
		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		// Handle tags like `json:"name,omitempty"`
		jsonName := strings.Split(jsonTag, ",")[0]
		if jsonName == "-" {
			continue
		}

		// Skip zero values
		if field.IsZero() {
			continue
		}

		// Convert to string
		params[jsonName] = fmt.Sprintf("%v", field.Interface())
	}

	return params
}

// ResponseData contains the data returned by the Weather API.
type ResponseData struct {
	TempC float64 `json:"tempC"`
	TempF float64 `json:"tempF"`
	WindMph float64 `json:"windMph"`
	WindKph float64 `json:"windKph"`
	WindDegree int `json:"windDegree"`
	WindDir string `json:"windDir"`
	PressureMb int `json:"pressureMb"`
	PressureIn float64 `json:"pressureIn"`
	PrecipMm int `json:"precipMm"`
	PrecipIn int `json:"precipIn"`
	FeelslikeC float64 `json:"feelslikeC"`
	FeelslikeF float64 `json:"feelslikeF"`
	VisKm int `json:"visKm"`
	VisMiles int `json:"visMiles"`
	GustMph float64 `json:"gustMph"`
	GustKph float64 `json:"gustKph"`
}

