using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.Weather
{
    /// <summary>
    /// Query options for the Weather API
    /// </summary>
    public class WeatherQueryOptions
    {
        /// <summary>
        /// The city for which you want to get the current weather (e.g., San Francisco)
        /// Example: San Francisco
        /// </summary>
        [JsonProperty("city")]
        public string City { get; set; }
    }
}
