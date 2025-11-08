declare module '@apiverve/weatherforecast' {
  export interface weatherforecastOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface weatherforecastResponse {
    status: string;
    error: string | null;
    data: any;
    code?: number;
  }

  export default class weatherforecastWrapper {
    constructor(options: weatherforecastOptions);

    execute(callback: (error: any, data: weatherforecastResponse | null) => void): Promise<weatherforecastResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: weatherforecastResponse | null) => void): Promise<weatherforecastResponse>;
    execute(query?: Record<string, any>): Promise<weatherforecastResponse>;
  }
}
