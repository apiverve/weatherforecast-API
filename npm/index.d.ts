declare module '@apiverve/weatherforecast' {
  export interface weatherforecastOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface weatherforecastResponse {
    status: string;
    error: string | null;
    data: WeatherData;
    code?: number;
  }


  interface WeatherData {
      tempC:      number;
      tempF:      number;
      windMph:    number;
      windKph:    number;
      windDegree: number;
      windDir:    string;
      pressureMB: number;
      pressureIn: number;
      precipMm:   number;
      precipIn:   number;
      feelslikeC: number;
      feelslikeF: number;
      visKM:      number;
      visMiles:   number;
      gustMph:    number;
      gustKph:    number;
  }

  export default class weatherforecastWrapper {
    constructor(options: weatherforecastOptions);

    execute(callback: (error: any, data: weatherforecastResponse | null) => void): Promise<weatherforecastResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: weatherforecastResponse | null) => void): Promise<weatherforecastResponse>;
    execute(query?: Record<string, any>): Promise<weatherforecastResponse>;
  }
}
