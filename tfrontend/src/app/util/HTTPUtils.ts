//
//
// Helper methods to work with HTTP
//
//
export class HTTPUtils {

  public static toUrlSearchParams(params: Map<string, string>, parseValues?: boolean): string {
    if (!params || params.size < 1) {
      return '';
    }

    // All chars will be parsed. Ex: ?asd=https:// -----> ?asd=https%3A%2F%2F
    if (parseValues) {
      const searchParams = new URLSearchParams();
      params.forEach((key, val) => searchParams.append(key, val));
      return searchParams.toString();
    }

    // Use params as is. Ex: ?asd=https:// -----> ?asd=https://
    let searchParams = '';
    params.forEach((val, key) =>
      searchParams += `${searchParams.length == 0 ? '?' : '&'}${key}=${val}`
    );

    return searchParams;
  }
}
